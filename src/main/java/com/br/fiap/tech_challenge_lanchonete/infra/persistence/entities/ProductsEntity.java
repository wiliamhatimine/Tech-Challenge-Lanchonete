package com.br.fiap.tech_challenge_lanchonete.infra.persistence.entities;

import java.io.IOException;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

import com.br.fiap.tech_challenge_lanchonete.domain.Product;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.CategorieEnums;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class ProductsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProduct;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "categorie")
	@Enumerated(EnumType.STRING)
	private CategorieEnums categorie;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image")
	private String image;

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

	public Product toModel() {
		return new Product(idProduct, name, categorie, price, description, image);
	}
	
}
