package com.f1000.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.f1000.rest.dao.ExchangeData;
import com.f1000.rest.dao.Product;
import com.f1000.rest.exception.ExchangeDataAccessException;
import com.f1000.rest.exception.IncorrectCurrencyTypeException;
import com.f1000.rest.service.IExchangeDataService;
import com.f1000.rest.service.IProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private IExchangeDataService exchangeDataService;

	@GetMapping(path = "/", produces = "application/json")
	public List<Product> getProducts() {
		try {
			//-- Get exchange info --//
			ExchangeData exchangeData = exchangeDataService.getExchangeDataInfo();
			//-- Filter required exchange rates with names --// 
			Map<String, Double> exchangeRates = exchangeDataService.getExchangeRates(exchangeData);
			//-- Update product list with different currencies --//
			return productService.getProductListByCurrency(exchangeRates);
			
		} catch (IncorrectCurrencyTypeException e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		} catch (ExchangeDataAccessException e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}		
	}

}
