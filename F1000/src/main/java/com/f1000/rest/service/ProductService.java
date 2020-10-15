package com.f1000.rest.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.f1000.rest.dao.Currency;
import com.f1000.rest.dao.Product;

@Service
public class ProductService implements IProductService {

	//-- Default product list --//
	private List<Product> productList = new ArrayList<Product>() {
		{
			Product product1 = new Product();
			product1.setProductId(1);
			product1.setProductName("Product 001");
			product1.setDescription("Description 001");
			product1.setPrice(10.0);
			add(product1);
			
			Product product2 = new Product();
			product2.setProductId(2);
			product2.setProductName("Product 002");
			product2.setDescription("Description 002");
			product2.setPrice(100.0);
			add(product2);
			
			Product product3 = new Product();
			product3.setProductId(3);
			product3.setProductName("Product 003");
			product3.setDescription("Description 003");
			product3.setPrice(1000.0);
			add(product3);
			
		}
	};
	
	@Override
	public List<Product> getProductList() {
		return this.productList;
	}

	@Override
	public List<Product> getProductListByCurrency(Map<String, Double> exchangeRates) {
		
		//-- Updating currencies with given currency types --//
		DecimalFormat format = new DecimalFormat("#.##");
		for(Product product : productList) {
			double originalPrice = product.getPrice();
			List<Currency> currencies = new ArrayList<>();
			
			for (String currencyName : exchangeRates.keySet()) {
			    	double rate = exchangeRates.get(currencyName);
			    	Currency currency = new Currency();
			    	currency.setName(currencyName);
			    	currency.setPrice(Double.valueOf(format.format(originalPrice * rate)));
			    	currencies.add(currency);
			}
			product.setCurrencies(currencies);
		}
		
		return productList;
	}
}
