package com.br.fiap.tech_challenge_lanchonete.application.ports.out;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.QueueEnums;

public interface QueuePort {
	
	Long clientMakeOrder(Long orderId);
	void moveToPreparing(Long jobId);
	Queue checkOrderStatus(Long idOrder);
	List<Queue> listClientOrders(QueueEnums status);
	void kitchenCompletedOrder(Long jobId);
	void orderWithdrawn(Long jobId);
	
}
