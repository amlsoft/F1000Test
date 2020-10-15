package com.f1000.rest.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeData {

	@JsonProperty
	private boolean success;
	@JsonProperty
	private long timestamp;
	@JsonProperty
	private String base;
	@JsonProperty
	private String date;
	@JsonProperty
	private ExchangeRates rates;

	public boolean getSuccess() {
		return success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getBase() {
		return base;
	}

	public String getDate() {
		return date;
	}

	@JsonProperty
	public ExchangeRates getExchangeRates() {
		return rates;
	}

}