package com.br.fiap.tech_challenge_lanchonete.application.usecases.queue;

import com.br.fiap.tech_challenge_lanchonete.domain.Queue;

public interface ClientMakeOrderUseCase {

	Queue checkOrderStatus(Long idOrder);
	
}
