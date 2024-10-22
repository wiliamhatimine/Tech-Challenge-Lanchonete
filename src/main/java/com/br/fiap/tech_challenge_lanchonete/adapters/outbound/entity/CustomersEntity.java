package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
public class CustomersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idCustomer;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Customer toModel() {
		return new Customer(name, email);
	}
	
	
	

}
