package com.technical.evaluation.domain;

public class Credit {

	private String result;
	private String limit;
	private Double similarity;

	public Credit() {
	}

	public Credit(CreditBuilder builder) {
		this.result = builder.result;
		this.limit = builder.limit;
		this.similarity = builder.similarity;
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

	public Double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Double similarity) {
		this.similarity = similarity;
	}

	public static class CreditBuilder {
		String result;
		String limit;
		Double similarity;

		public CreditBuilder result(String result) {
			this.result = result;
			return this;
		}

		public CreditBuilder limit(String limit) {
			this.limit = limit;
			return this;
		}

		public CreditBuilder similarity(Double similarity) {
			this.similarity = similarity;
			return this;
		}

		public Credit build() {
			return new Credit(this);
		}
	}

}
