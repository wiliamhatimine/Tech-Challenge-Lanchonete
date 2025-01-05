package com.br.fiap.tech_challenge_lanchonete.domain;

public class ProductOrder{

	private Long idProduct;
	private Double price;
	private String name;
	private int quantity;
	
	public ProductOrder() {
	}
	public ProductOrder(Long idProduct, Double price, String name, int quantity) {
		super();
		this.idProduct = idProduct;
		this.price = price;
		this.name = name;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
