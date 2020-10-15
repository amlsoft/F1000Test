package com.f1000.rest.service;

import java.util.List;
import java.util.Map;

import com.f1000.rest.dao.Product;

public interface IProductService {
	List<Product> getProductList();
	List<Product> getProductListByCurrency(Map<String, Double> exchangeRates);
}
