package com.br.fiap.tech_challenge_lanchonete.application.core.domain;

public class ProductOrder{

	private Long idProduct;
	private Double price;
	private String name;
	private int amount;
	
	public ProductOrder() {
	}
	
	public ProductOrder(Long idProduct, Double price, String name, int amount) {
		super();
		this.idProduct = idProduct;
		this.price = price;
		this.name = name;
		this.amount = amount;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
