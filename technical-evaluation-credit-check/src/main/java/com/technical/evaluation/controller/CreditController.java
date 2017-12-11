package com.technical.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical.evaluation.domain.UserCreditCheck;
import com.technical.evaluation.service.CreditService;

@RestController
@RequestMapping(value = "credit")
public class CreditController {
	
	@Autowired
	private CreditService service;
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<UserCreditCheck> get(@PathVariable("cpf") String cpf) throws Exception {
		return ResponseEntity.ok(this.service.getUserAndAnalize(cpf));
	}
	
}
