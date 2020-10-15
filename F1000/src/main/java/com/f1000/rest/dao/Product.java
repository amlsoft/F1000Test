package com.f1000.rest.dao;

import java.util.List;

public class Product {

	private int productId;
	private String productName;
	private String description;
	private double price;
	private List<Currency> currencies;
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
	
	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
	
	public List<Currency> getCurrencies() {
		return currencies;
	}
	
	@Override
    public String toString() {
        return "Product [ProductId=" + productId + ", ProductName=" + productName + 
        		", description=" + description + ", price=" + price + "]";
    }
}
