package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.ProductOrder;

import jakarta.persistence.Column;
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
	private List<ProductOrder> products;

	private Double total = 0.0;
	
	public OrderEntity() {
	}

	public OrderEntity(Long idOrder, Long customer, List<ProductOrder> products) {
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

	public List<ProductOrder> getProducts() {
		return products;
	}

	public void setProducts(List<ProductOrder> products) {
		this.products = products;
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


	public Order getOrder(List<ProductOrder> products, Double total) {
		return new Order(idOrder, customer, total, products);
	}
	
	public Order toModel(OrderEntity order) {
		return new Order(order.getIdOrder(), order.getCustomer(), order.getTotal(), order.getProducts());
	}
	
}
