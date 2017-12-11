package com.technical.evaluation;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.technical.evaluation.domain.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetUsersStepTest extends AbstractSpringConfigurationTest<User> {

	private static final Logger log = LoggerFactory.getLogger(GetUsersStepTest.class);
	
	private ResponseEntity<User> response;
	
	@Given("^o cliente \"([^\"]*)\" e id (\\d+)$")
	public void o_cliente_e_id(String userName, Long id) throws Throwable {
		log.info(String.format("UserName: %s", userName));
		log.info(String.format("UserId: %s", id));
	}
	
	@Given("^o cliente \"([^\"]*)\" e cpf \"([^\"]*)\"$")
	public void o_cliente_e_cpf(String userName, String cpf) throws Throwable {
		log.info(String.format("UserName: %s", userName));
		log.info(String.format("CPF: %s", cpf));
	}

	@When("^ao executar GET \"([^\"]*)\" com id igual (\\d+)$")
	public void ao_executar_GET_com_id_igual(String userName, Long id) throws Throwable {
		String url = buildUrl(HOST, PORT, String.format("/users/-%s", id));
		HttpEntity<User> requestEntity = new HttpEntity<>(getDefaultHttpHeaders());
		response = invokeRESTCall(url, HttpMethod.GET, requestEntity, User.class);
	}
	
	@When("^ao executar GET \"([^\"]*)\" com cpf igual \"([^\"]*)\"$")
	public void ao_executar_GET_com_cpf_igual(String userName, String cpf) throws Throwable {
		String url = buildUrl(HOST, PORT, String.format("/users/%s", cpf));
		HttpEntity<User> requestEntity = new HttpEntity<>(getDefaultHttpHeaders());
		response = invokeRESTCall(url, HttpMethod.GET, requestEntity, User.class);
	}

	@Then("^o servidor retorna status code igual a (\\d+)$")
	public void o_servidor_retorna_status_code_igual_a(int statusCode) throws Throwable {
		assertEquals(statusCode, response.getStatusCode().value());
	}

	@Then("^e o retorno contem user name \"([^\"]*)\"$")
	public void e_o_retorno_contem_user_name(String userName) throws Throwable {
		assertEquals(userName, response.getBody().getName());
	}
	
}
