package com.technical.evaluation.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.technical.evaluation.domain.converter.GenderConverter;
import com.technical.evaluation.domain.converter.StatusConverter;

@Entity
@Table
public class User {
	@Id @GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String cpf;
	@Column(name = "years_old")
	private Long yearsOld;
	@Convert(converter = GenderConverter.class)
	private Gender gender;
	@Convert(converter = StatusConverter.class)
	private Status status;
	@Column
	private String state;
	@Column
	private Long dependent;
	@Column(precision = 2, scale = 2)
	private BigDecimal income;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Long getYearsOld() {
		return yearsOld;
	}
	
	public void setYearsOld(Long yearsOld) {
		this.yearsOld = yearsOld;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Long getDependent() {
		return dependent;
	}
	
	public void setDependent(Long dependent) {
		this.dependent = dependent;
	}
	
	public BigDecimal getIncome() {
		return income;
	}
	
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	
}
