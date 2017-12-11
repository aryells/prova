package com.technical.evaluation.repository;

import org.springframework.stereotype.Component;

import weka.core.Instances;

@Component
public class CreditApprovedRepository extends CreditRepository {
	
	public Instances getInstaces() throws Exception {
		return getInstaces("classpath:data_approved.arff");
	}
	
}
