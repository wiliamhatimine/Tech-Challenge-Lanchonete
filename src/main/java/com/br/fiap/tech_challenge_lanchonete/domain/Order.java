package com.br.fiap.tech_challenge_lanchonete.domain;

import java.util.List;

public class Order {

	private Long idOrder;
	private Long customer;
	private Double total;
	private List<ProductOrder> products;
	
	public Order() {}
	
 	public Order(Long idOrder, Long customer, Double total, List<ProductOrder> products) {
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
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public List<ProductOrder> getProducts() {
		return products;
	}
	public void setProducts(List<ProductOrder> products) {
		this.products = products;
	}
}
