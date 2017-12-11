package com.technical.evaluation;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.technical.evaluation.domain.User;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateUsersStepTest extends AbstractSpringConfigurationTest<User> {

	private static final Logger log = LoggerFactory.getLogger(CreateUsersStepTest.class);
	
	private ResponseEntity<User> response;
	private User user;
	
	@Given("^o dados do novo usuario:$")
	public void o_dados_do_novo_usuario(DataTable usersDataTable) throws Throwable {
		user = usersDataTable.asList(User.class).get(0);
		log.info(String.format("UserName: %s", user.getName()));
	}

	@When("^o cliente executa \"([^\"]*)\" com os dados fornecidos$")
	public void o_cliente_executa_com_os_dados_fornecidos(String arg1) throws Throwable {
		String url = buildUrl(HOST, PORT, "/users");
		HttpEntity<User> requestEntity = new HttpEntity<>(user, getDefaultHttpHeaders());
		response = invokeRESTCall(url, HttpMethod.POST, requestEntity, User.class);
	}
	
	@Then("^o servidor retorna status code (\\d+) Created$")
	public void o_servidor_retorna_status_code_igual_a(int statusCode) throws Throwable {
		assertEquals(statusCode, response.getStatusCode().value());
	}
	
}
