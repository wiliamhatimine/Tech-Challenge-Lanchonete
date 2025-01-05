package com.br.fiap.tech_challenge_lanchonete.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.domain.enums.QueueEnums;

public class Queue {

	private Long jobId;
	private Long orderId;
	private List<ProductOrder> products;
	private QueueEnums status;
	private LocalDateTime startedAt;
	private LocalDateTime finishedAt;
	
	public Queue() {
	}
	
	public Queue(Long jobId, Long orderId, List<ProductOrder> products, QueueEnums status, LocalDateTime startedAt, LocalDateTime finishedAt) {
		this.jobId = jobId;
		this.orderId = orderId;
		this.products = products;
		this.status = status;
		this.startedAt = startedAt;
		this.finishedAt = finishedAt;
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
	public LocalDateTime getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}
	public LocalDateTime getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(LocalDateTime finishedAt) {
		this.finishedAt = finishedAt;
	}
}
