package com.br.fiap.tech_challenge_lanchonete.gateway;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.QueueEnums;

public interface QueueRepositoryGateway {
	
	Long clientMakeOrder(Long orderId);
	void moveToPreparing(Long jobId);
	Queue checkOrderStatus(Long idOrder);
	List<Queue> listClientOrders(QueueEnums status);
	void kitchenCompletedOrder(Long jobId);
	void orderWithdrawn(Long jobId);
	
}
