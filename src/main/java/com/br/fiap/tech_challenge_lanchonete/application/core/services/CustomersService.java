package com.br.fiap.tech_challenge_lanchonete.application.core.services;

import com.br.fiap.tech_challenge_lanchonete.application.ports.in.SignUpCustomerUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.CustomersPort;

public final class CustomersService implements SignUpCustomerUseCase{

	private CustomersPort customersPort;

	public CustomersService(CustomersPort customersPort) {
		this.customersPort = customersPort;
	}
	
	@Override
	public void save(String name, String email) {
		customersPort.save(name, email);
	}

}
