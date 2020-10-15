package com.f1000.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.f1000.rest.dao.ExchangeData;
import com.f1000.rest.exception.ExchangeDataAccessException;
import com.f1000.rest.exception.IncorrectCurrencyTypeException;
import com.f1000.rest.utility.ConfigUtility;
import com.f1000.rest.utility.CurrencyUtility;

@Service
public class ExchangeDataService implements IExchangeDataService {

	@Autowired
	private ConfigUtility configUtility;

	@Autowired
	private CurrencyUtility currencyUtility;

	//-- Supported exchange currency types --//
	private List<String> supportedCurrencies = new ArrayList() {
		{
			add("EUR");
			add("GBP");
			add("USD");
		}
	};

	private final RestTemplate restTemplate;

	public ExchangeDataService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public ExchangeData getExchangeDataInfo() throws ExchangeDataAccessException {
		try {
			String key = (configUtility.getProperty("fixer.io.key") != null) ? configUtility.getProperty("fixer.io.key")
					: "5ae1fcc1473a0ec42570d7149aaaadd5";

			String url = "http://data.fixer.io/api/latest?access_key=" + key;
			return this.restTemplate.getForObject(url, ExchangeData.class);
		} catch (Exception e) {
			throw new ExchangeDataAccessException("Error in exchange data access endpoint " + e.getMessage());
		}
	}

	@Override
	public Map<String, Double> getExchangeRates(ExchangeData exchangeData) throws IncorrectCurrencyTypeException {
		Map<String, Double> exchangeRateMap = new HashMap<>();
		for (String currency : supportedCurrencies) {
			//-- Get the exchange rate using the method reflection --// ???
			double rate = currencyUtility.getCurrencyRate(exchangeData.getExchangeRates(), currency);
			exchangeRateMap.put(currency, rate);
		}

		return exchangeRateMap;
	}
}
