package com.br.fiap.tech_challenge_lanchonete.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class CustomersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCustomer;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;

	public CustomersEntity(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public CustomersEntity() {
	}


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
	
	
	

}
