package com.technical.evaluation.domain;

public enum TypeCredit {
	APPROVED_100_500("Aprovado", "entre 100 - 500"), APPROVED_500_1000("Aprovado", "entre 500 - 1000"), APPROVED_1000_1500("Aprovado", "entre 1000 - 1500"), APPROVED_1500_2000("Aprovado", "entre 1500 - 2000"), APPROVED_2000_PLUS("Aprovado", "superior 2000"), DENIED_POLICY("Negado", "reprovado pela política de crédito"), DENIED_LOW_INCOME("Negado", "renda baixa");
	
	private String result;
	private String limit;
	
	TypeCredit(String result, String limit) {
		this.result = result;
		this.limit = limit;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}
	
	public Credit newCredit(Double similarity) {
		return new Credit.CreditBuilder().result(this.result).limit(limit).similarity(similarity).build();
	}
}

