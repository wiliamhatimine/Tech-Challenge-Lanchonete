package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.QueueEnums;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.queue.Queue;

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
@Table(name = "queue_order")
@NoArgsConstructor
@AllArgsConstructor
public class QueueEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long jobId;
	
	@Column(name = "id_order")
	private Long idOrder;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private QueueEnums status;
	
	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name="payload", columnDefinition = "jsonb")
	private List<String> productsName;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public QueueEnums getStatus() {
		return status;
	}

	public void setStatus(QueueEnums status) {
		this.status = status;
	}

	public List<String> getProductsName() {
		return productsName;
	}

	public void setProductsName(List<String> productsName) {
		this.productsName = productsName;
	}
	
	public Queue toModel() {
		return new Queue(jobId, idOrder, productsName, status);
	}
	
	
}
