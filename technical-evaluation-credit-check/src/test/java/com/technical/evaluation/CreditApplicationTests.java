package com.technical.evaluation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.technical.evaluation.domain.UserCreditCheck;
import com.technical.evaluation.service.CreditService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditApplicationTests {

	@Autowired
	public CreditService service;

	@Test
	public void test_lucas() throws Exception {
		UserCreditCheck user = new UserCreditCheck.UserCreditCheckBuilder().name("Lucas").yearsOld(28L).gender("M").status("solteiro").dependent(0L).income(2500D).build();
		service.creditCheckApprovedOrDenied(user);
		System.out.println(String.format("Nome: %s - %s - %s", user.getName(), user.getCredit().getResult(), user.getCredit().getLimit()));
	}
	
	@Test
	public void test_ana() throws Exception {
		UserCreditCheck user = new UserCreditCheck.UserCreditCheckBuilder().name("Ana").yearsOld(17L).gender("F").status("solteiro").dependent(0L).income(1000D).build();
		service.creditCheckApprovedOrDenied(user);
		System.out.println(String.format("Nome: %s - %s - %s", user.getName(), user.getCredit().getResult(), user.getCredit().getLimit()));
	}

}
