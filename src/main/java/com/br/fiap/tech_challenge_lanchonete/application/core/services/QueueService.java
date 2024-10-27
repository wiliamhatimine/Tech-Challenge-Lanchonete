package com.br.fiap.tech_challenge_lanchonete.application.core.services;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.queue.Queue;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.ClientMakeOrderUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.in.KitchenOrderUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.QueuePort;

public class QueueService implements ClientMakeOrderUseCase, KitchenOrderUseCase {

	private QueuePort queuePort;
	
	QueueService(QueuePort queuePort){
		this.queuePort = queuePort;
	}
	
	@Override
	public Boolean updateOrderStatusToStarted(String jobId, Long orderId) {
		return queuePort.startOrderToPrepare(jobId, orderId);
	}
	
	@Override
	public Boolean completeOrder(String jobId, Long orderId) {
		return queuePort.kitchenCompletedOrder(jobId, orderId);
	}

	@Override
	public Queue checkOrderStatus(Long orderId) {
		return queuePort.checkOrderStatus(orderId);
	}
}
