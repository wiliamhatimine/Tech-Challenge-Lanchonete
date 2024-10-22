package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.dto;

import java.io.Serializable;
import java.util.Map;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable{

	@JsonProperty("product")
	private Map<Product, Integer> product;

	
	public Map<Product, Integer> getProduct() {
		return product;
	}

	public void setProduct(Map<Product, Integer> product) {
		this.product = product;
	}
	
	
}
