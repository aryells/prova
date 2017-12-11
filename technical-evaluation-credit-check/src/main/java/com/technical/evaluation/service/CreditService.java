package com.technical.evaluation.service;

import static com.technical.evaluation.domain.TypeCredit.APPROVED_1000_1500;
import static com.technical.evaluation.domain.TypeCredit.APPROVED_100_500;
import static com.technical.evaluation.domain.TypeCredit.APPROVED_1500_2000;
import static com.technical.evaluation.domain.TypeCredit.APPROVED_2000_PLUS;
import static com.technical.evaluation.domain.TypeCredit.APPROVED_500_1000;
import static com.technical.evaluation.domain.TypeCredit.DENIED_LOW_INCOME;
import static com.technical.evaluation.domain.TypeCredit.DENIED_POLICY;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.technical.evaluation.domain.Credit;
import com.technical.evaluation.domain.UserCreditCheck;
import com.technical.evaluation.repository.CreditApprovedRepository;
import com.technical.evaluation.repository.CreditDeniedRepository;
import com.technical.evaluation.repository.CreditRepository;

@Service
public class CreditService {
	
	@Value("${com.technical.evaluation.user.server.port}")
	private String serverPort;
	
	@Value("${com.technical.evaluation.user.server.host}")
	private String serverHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private CreditApprovedRepository creditApprovedRepository;
	
	@Autowired
	private CreditDeniedRepository creditDeniedRepository;
	
	public UserCreditCheck getUserAndAnalize(String cpf) throws Exception {
		String url = buildUrl(serverHost, serverPort, String.format("/users/%s", cpf));
		HttpEntity<UserCreditCheck> requestEntity = new HttpEntity<>(getDefaultHttpHeaders());
		UserCreditCheck user= restTemplate.exchange(url, HttpMethod.GET, requestEntity, UserCreditCheck.class).getBody();
		if (user == null) {
			throw new Exception("Registro não encontrado.");
		}
		creditCheckApprovedOrDenied(user);
		return user; 
	}
	
	public void creditCheckApprovedOrDenied(UserCreditCheck user) throws Exception {
		List<Double> analyze = creditRepository.getAnalyze(user);
		Double approvedOrDenied = analyze.stream().max((d1, d2) -> d1.compareTo(d2)).get();
		Double approved = analyze.stream().findFirst().get();
		if(approved.equals(approvedOrDenied)) {
			creditAppredLimit(user);
		} else {
			creditDeniedCause(user);
		}
	}
	
	private void creditAppredLimit(UserCreditCheck user) throws Exception {
		List<Double> analyze = creditApprovedRepository.getAnalyze(user);
		List<Credit> creditAnalize = new ArrayList<>();
		creditAnalize.add(APPROVED_100_500.newCredit(analyze.get(0)));
		creditAnalize.add(APPROVED_500_1000.newCredit(analyze.get(1)));
		creditAnalize.add(APPROVED_1000_1500.newCredit(analyze.get(2)));
		creditAnalize.add(APPROVED_1500_2000.newCredit(analyze.get(3)));
		creditAnalize.add(APPROVED_2000_PLUS.newCredit(analyze.get(4)));
		user.setCredit(getMaxSimilarity(creditAnalize));
	}

	private void creditDeniedCause(UserCreditCheck user) throws Exception {
		List<Double> analyze = creditDeniedRepository.getAnalyze(user);
		List<Credit> creditAnalize = new ArrayList<>();
		creditAnalize.add(DENIED_POLICY.newCredit(analyze.get(0)));
		creditAnalize.add(DENIED_LOW_INCOME.newCredit(analyze.get(1)));
		user.setCredit(getMaxSimilarity(creditAnalize));
	}
	
	private Credit getMaxSimilarity(List<Credit> creditAnalize) {
		return creditAnalize.stream().max((c1, c2) -> c1.getSimilarity().compareTo(c2.getSimilarity())).get();
	}
	
	private HttpHeaders getDefaultHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return headers;
	}
	
	private String buildUrl(String host, String port, String path, Map<String, String> uriVariables) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path).host(host).port(port).scheme("http");
		UriComponents uriComponent = uriVariables != null && !uriVariables.isEmpty()
				? builder.buildAndExpand(uriVariables) : builder.build();
		return uriComponent.toUri().toString();
	}

	private String buildUrl(String host, String port, String path) {
		return buildUrl(host, port, path, null);
	}
	
}
