package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Customer;

public interface LoginUseCase {
	Customer saveCustomer(Customer customer);
}
