package com.br.fiap.tech_challenge_lanchonete.application.core.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Order {

	private Long idOrder;
	private Long customer;
	private BigDecimal total;
	private Map<Product, Integer> products;
	
	public Order() {}
	
	public Order(Long idOrder, Long customer, BigDecimal total, Map<Product, Integer> products) {
		super();
		this.idOrder = idOrder;
		this.customer = customer;
		this.total = total;
		this.products = products;
	}
	
	public Long getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Map<Product, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}
}
