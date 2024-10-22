package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.converter.ProductConverter;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_customers")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idOrder;
	
	@Column(name = "customer")
	private Long customer;
	
	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name="products", columnDefinition = "jsonb")
	private Map<Product, Integer> products;

	public OrderEntity() {
	}

	public OrderEntity(Long idOrder, Long customer, Map<Product, Integer> products) {
		this.idOrder = idOrder;
		this.customer = customer;
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

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProduct(Map<Product, Integer> products) {
		this.products = products;
	}
	
	public Order getOrder(Map<Product, Integer> products) {
		BigDecimal total = null;
			products.forEach((keyProduct, amount) -> {
				if(amount > 1) {
					total.add(keyProduct.getPrice().multiply(BigDecimal.valueOf(amount)));
				}else {
					total.add(keyProduct.getPrice());
				}
			});
		return new Order(idOrder, customer, total, products);
	}
	
}
