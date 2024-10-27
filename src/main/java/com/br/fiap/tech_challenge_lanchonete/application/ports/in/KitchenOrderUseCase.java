package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

public interface KitchenOrderUseCase {

	Boolean updateOrderStatusToStarted(String jobId, Long orderId);
	Boolean completeOrder(String jobId, Long orderId);
	
}
