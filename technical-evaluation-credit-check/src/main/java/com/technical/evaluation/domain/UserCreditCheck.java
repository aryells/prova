package com.technical.evaluation.domain;

public class UserCreditCheck {

	private Long id;
	private String name;
	private String cpf;
	private Long yearsOld;
	private String gender;
	private String status;
	private String state;
	private Long dependent;
	private Double income;
	private Credit credit;

	public UserCreditCheck() {
	}

	public UserCreditCheck(UserCreditCheckBuilder builder) {
		this.name = builder.name;
		this.cpf = builder.cpf;
		this.yearsOld = builder.yearsOld;
		this.gender = builder.gender;
		this.status = builder.status;
		this.state = builder.state;
		this.dependent = builder.dependent;
		this.income = builder.income;
		this.credit = builder.credit;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public static class UserCreditCheckBuilder {
		private String name;
		private String cpf;
		private Long yearsOld;
		private String gender;
		private String status;
		private String state;
		private Long dependent;
		private Double income;
		private Credit credit;

		public UserCreditCheckBuilder name(String name) {
			this.name = name;
			return this;
		}

		public UserCreditCheckBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public UserCreditCheckBuilder yearsOld(Long yearsOld) {
			this.yearsOld = yearsOld;
			return this;
		}

		public UserCreditCheckBuilder gender(String gender) {
			this.gender = gender;
			return this;
		}

		public UserCreditCheckBuilder status(String status) {
			this.status = status;
			return this;
		}

		public UserCreditCheckBuilder state(String state) {
			this.state = state;
			return this;
		}

		public UserCreditCheckBuilder dependent(Long dependent) {
			this.dependent = dependent;
			return this;
		}

		public UserCreditCheckBuilder income(Double income) {
			this.income = income;
			return this;
		}

		public UserCreditCheckBuilder credit(Credit credit) {
			this.credit = credit;
			return this;
		}

		public UserCreditCheck build() {
			return new UserCreditCheck(this);
		}
	}

}
