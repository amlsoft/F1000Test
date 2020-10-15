package com.f1000.rest.utility;

import java.lang.reflect.Method;

import org.springframework.context.annotation.Configuration;

import com.f1000.rest.dao.ExchangeRates;
import com.f1000.rest.exception.IncorrectCurrencyTypeException;

@Configuration
public class CurrencyUtility {
	public double getCurrencyRate(ExchangeRates exchangeRates, String currencyName) 
			throws IncorrectCurrencyTypeException {
		double rate = 0;
		try {
			Method method = ExchangeRates.class.getMethod("get" + currencyName.toUpperCase());
			rate = (Double) method.invoke(exchangeRates);
			return rate;
		} catch (Exception e) {
			throw new IncorrectCurrencyTypeException("Currency type name "+currencyName+" is not supported");
		}		
	}
}