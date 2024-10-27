package com.br.fiap.tech_challenge_lanchonete.application.core.domain;

import java.time.LocalDateTime;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;

public class Payment {

	private Long idPayment;
	private Long idOrder;
	private PaymentStatusEnums paymentStatus;
	private LocalDateTime updatedStatus;
	
	public Payment() {
		super();
	}
	
	public Payment(Long idPayment, Long idOrder, PaymentStatusEnums paymentStatus, LocalDateTime updatedStatus) {
		super();
		this.idPayment = idPayment;
		this.idOrder = idOrder;
		this.paymentStatus = paymentStatus;
		this.updatedStatus = updatedStatus;
	}
	public Long getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(Long idPayment) {
		this.idPayment = idPayment;
	}
	public Long getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
	public PaymentStatusEnums getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatusEnums paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public LocalDateTime getUpdatedStatus() {
		return updatedStatus;
	}
	public void setUpdatedStatus(LocalDateTime updatedStatus) {
		this.updatedStatus = updatedStatus;
	}
	
	
	
	
}
