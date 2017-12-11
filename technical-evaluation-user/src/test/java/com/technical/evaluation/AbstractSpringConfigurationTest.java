package com.technical.evaluation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(classes = UserApplication.class)
public abstract class AbstractSpringConfigurationTest<T> {

	@Autowired(required = false)
	private TestRestTemplate restTemplate;

	protected static final String HOST = "localhost";
	protected static final String PORT = "8080";

	public TestRestTemplate getRestTemplate() {
		return restTemplate != null ? restTemplate : new TestRestTemplate();
	}

	public void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<T> invokeRESTCall(String url, HttpMethod method, HttpEntity<T> requestEntity, Class<T> clazz) {
		return getRestTemplate().exchange(url, method, requestEntity, clazz);
	}

	public HttpHeaders getDefaultHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return headers;
	}

	public String buildUrl(String host, String port, String path, Map<String, String> uriVariables) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path).host(host).port(port).scheme("http");
		UriComponents uriComponent = uriVariables != null && !uriVariables.isEmpty()
				? builder.buildAndExpand(uriVariables) : builder.build();
		return uriComponent.toUri().toString();
	}

	public String buildUrl(String host, String port, String path) {
		return buildUrl(host, port, path, null);
	}

}
