package com.br.fiap.tech_challenge_lanchonete.application.ports.in;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.QueueEnums;

public interface ManageQueueUseCase {

	Long clientMakeOrder(Long orderId);
	void moveToPreparing(Long idOrder);
	Queue checkOrderStatus(Long idOrder);
	List<Queue> listClientOrders(QueueEnums status);
	void kitchenCompletedOrder(Long idOrder);
	void orderWithdrawn(Long idOrder);
	
}
