package com.br.fiap.tech_challenge_lanchonete.application.core.domain;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.QueueEnums;

public class Queue {

	private Long jobId;
	private Long orderId;
	private List<ProductOrder> products;
	private QueueEnums status;
	
	public Queue() {
	}
	
	public Queue(Long jobId, Long orderId, List<ProductOrder> products, QueueEnums status) {
		this.jobId = jobId;
		this.orderId = orderId;
		this.products = products;
		this.status = status;
	}
	
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public List<ProductOrder> getProducts() {
		return products;
	}
	public void setProducts(List<ProductOrder> products) {
		this.products = products;
	}
	public QueueEnums getStatus() {
		return status;
	}
	public void setStatus(QueueEnums status) {
		this.status = status;
	}
	
	
	
}
