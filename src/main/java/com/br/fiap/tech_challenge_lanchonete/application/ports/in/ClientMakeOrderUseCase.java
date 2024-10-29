package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Queue;

public interface ClientMakeOrderUseCase {

	Queue checkOrderStatus(Long idOrder);
	
}
