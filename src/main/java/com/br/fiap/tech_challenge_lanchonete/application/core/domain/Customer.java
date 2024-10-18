package com.br.fiap.tech_challenge_lanchonete.application.core.domain;

public class Customer {

	private String name;
	private String email;

	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
