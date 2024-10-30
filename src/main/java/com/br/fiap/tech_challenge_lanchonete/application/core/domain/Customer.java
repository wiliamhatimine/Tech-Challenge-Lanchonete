package com.br.fiap.tech_challenge_lanchonete.application.core.domain;

public class Customer {

	private Long idCustomer;
	private String name;
	private String email;
	private String cpf;

	public Customer(Long idCustomer, String name, String email,String cpf) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
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
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
}
