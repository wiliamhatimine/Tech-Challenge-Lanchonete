package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity;

import java.time.LocalDateTime;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Payment;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.PaymentStatusEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idPayment;
	
	@Column(name = "id_order")
	private Long idOrder;
	
	@Column(name = "id_customer")
	private Long idCustomer;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private PaymentStatusEnums status;
	
	@Column(name = "updated_status")
	private LocalDateTime updatedStatus;

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
	
	public Long getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public PaymentStatusEnums getStatus() {
		return status;
	}

	public void setStatus(PaymentStatusEnums status) {
		this.status = status;
	}

	public LocalDateTime getUpdatedStatus() {
		return updatedStatus;
	}

	public void setUpdatedStatus(LocalDateTime updatedStatus) {
		this.updatedStatus = updatedStatus;
	}
	
	public Payment toModel() {
		return new Payment(idPayment, idOrder, idCustomer, status, updatedStatus);
	}
	
}
