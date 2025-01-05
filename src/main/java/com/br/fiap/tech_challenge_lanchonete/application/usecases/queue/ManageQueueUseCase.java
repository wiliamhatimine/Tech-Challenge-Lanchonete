package com.br.fiap.tech_challenge_lanchonete.application.usecases.queue;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.domain.enums.QueueEnums;

public interface ManageQueueUseCase {

	Long clientMakeOrder(Long orderId);
	void moveToPreparing(Long idOrder);
	Queue checkOrderStatus(Long idOrder);
	List<Queue> listClientOrders(QueueEnums status);
	void kitchenCompletedOrder(Long idOrder);
	void orderWithdrawn(Long idOrder);
	
}
