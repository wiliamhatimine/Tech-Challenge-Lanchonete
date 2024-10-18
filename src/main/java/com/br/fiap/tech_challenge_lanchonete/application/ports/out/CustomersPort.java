package com.br.fiap.tech_challenge_lanchonete.application.ports.out;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;

public interface CustomersPort {

	Customer save(String name, String email);
	String getCustomerId(String customerId);
}
