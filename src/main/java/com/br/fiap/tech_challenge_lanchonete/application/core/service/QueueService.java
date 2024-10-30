package com.br.fiap.tech_challenge_lanchonete.application.core.service;

import java.util.List;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.QueueEnums;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.ManageQueueUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.QueuePort;

public class QueueService implements ManageQueueUseCase {

	private QueuePort queuePort;
	
	@Override
	public Long clientMakeOrder(Long orderId) {
		return queuePort.clientMakeOrder(orderId);
	}

	@Override
	public void moveToPreparing(Long idOrder) {
		queuePort.moveToPreparing(idOrder);
	}

	@Override
	public Queue checkOrderStatus(Long idOrder) {
		return queuePort.checkOrderStatus(idOrder);
	}

	@Override
	public List<Queue> listClientOrders(QueueEnums status) {
		return queuePort.listClientOrders(status);
	}

	@Override
	public void kitchenCompletedOrder(Long idOrder) {
		queuePort.kitchenCompletedOrder(idOrder);
		
	}

	@Override
	public void orderWithdrawn(Long idOrder) {
		queuePort.orderWithdrawn(idOrder);
	}

}
