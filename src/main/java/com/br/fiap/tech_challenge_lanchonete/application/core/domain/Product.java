package com.br.fiap.tech_challenge_lanchonete.application.core.domain;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.CategorieEnums;

public class Product {

	private Long idProduct;
	private String name;
	private CategorieEnums categorie;
	private Double price;
	private String description;
	private String image;
	
	public Product() {
	}
	
	public Product(Long idProduct, String name, CategorieEnums categorie, Double price, String description, String image) {
		this.idProduct = idProduct;
		this.name = name;
		this.categorie = categorie;
		this.price = price;
		this.description = description;
		this.image = image;
	}
	
	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategorieEnums getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieEnums categorie) {
		this.categorie = categorie;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
