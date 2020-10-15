package com.f1000.rest.service;

import java.util.Map;

import com.f1000.rest.dao.ExchangeData;
import com.f1000.rest.exception.ExchangeDataAccessException;
import com.f1000.rest.exception.IncorrectCurrencyTypeException;

public interface IExchangeDataService {
	ExchangeData getExchangeDataInfo() throws ExchangeDataAccessException;
	Map<String, Double> getExchangeRates(ExchangeData exchangeData) throws IncorrectCurrencyTypeException;
}
