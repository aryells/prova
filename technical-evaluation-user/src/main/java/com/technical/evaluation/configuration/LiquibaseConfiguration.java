package com.technical.evaluation.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfiguration {

	@Bean @Autowired
	public SpringLiquibase liquibase(DataSource dataSource) {
	    SpringLiquibase liquibase = new SpringLiquibase();
	    liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
	    liquibase.setDataSource(dataSource);
	    return liquibase;
	}
	
}