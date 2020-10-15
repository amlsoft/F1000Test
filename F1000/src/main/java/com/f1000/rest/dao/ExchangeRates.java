package com.f1000.rest.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeRates {

	@JsonProperty("GBP") 
    public double gBP;
    @JsonProperty("USD") 
    public double uSD;
    @JsonProperty("EUR") 
    public double eUR;
    
    @JsonProperty("GBP") 
	public void setGBP(double gBP) {
		this.gBP = gBP;
	}

	@JsonProperty("USD") 
	public void setUSD(double uSD) {
		this.uSD = uSD;
	}
	
	@JsonProperty("EUR") 
	public void setEUR(double eUR) {
		this.eUR = eUR;
	}
		
	@JsonProperty("GBP") 
	public double getGBP() {
		return gBP;
	}

	@JsonProperty("USD") 
	public double getUSD() {
		return uSD;
	}
	
	@JsonProperty("EUR") 
	public double getEUR() {
		return eUR;
	}
}