package com.br.fiap.tech_challenge_lanchonete.application.core.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.CategorieEnums;

public class Product {

	private Long id;
	private String name;
	private CategorieEnums categorie;
	private BigDecimal price;
	private String description;
	private byte image;
	
	public Product(Long id, String name, CategorieEnums categorie, BigDecimal price, String description, byte image) {
		this.id = id;
		this.name = name;
		this.categorie = categorie;
		this.price = price;
		this.description = description;
		this.image = image;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte getImage() {
		return image;
	}
	public void setImage(byte image) {
		this.image = image;
	}
	
}
