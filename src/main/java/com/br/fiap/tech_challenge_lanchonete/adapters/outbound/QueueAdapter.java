package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.OrderEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.QueueEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.OrderRepository;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.QueueRepository;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.ProductOrder;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Queue;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.QueueEnums;
import com.br.fiap.tech_challenge_lanchonete.application.ports.out.QueuePort;

@Component
public class QueueAdapter implements QueuePort {

	private QueueRepository queueRepository;
	private OrderRepository orderRepository;
	
	public QueueAdapter(QueueRepository queueRepository, OrderRepository orderRepository) {
		this.queueRepository = queueRepository;
		this.orderRepository = orderRepository;
	}
	
	@Override
	public Long clientMakeOrder(Long orderId) {
		OrderEntity orderEntity = orderRepository.findById(orderId).get();
		List<ProductOrder> listNames = orderEntity.getProducts();
		
		QueueEntity queueEntity = new QueueEntity();
		queueEntity.setIdOrder(orderId);
		queueEntity.setProductsName(listNames);
		queueEntity.setStatus(QueueEnums.RECEBIDO);
		queueEntity.setStartedAt(LocalDateTime.now());
		return queueRepository.save(queueEntity).getJobId();
	}

	@Override
	public void moveToPreparing(Long idOrder) {
		QueueEntity queueEntity = queueRepository.findByIdOrder(idOrder);
		queueEntity.setStatus(QueueEnums.EM_PREPARACAO);
		queueRepository.save(queueEntity);
	}

	@Override
	public Queue checkOrderStatus(Long idOrder) {
		return queueRepository.findByIdOrder(idOrder).toModel();
	}

	@Override
	public List<Queue> listClientOrders(QueueEnums status) {
		return queueRepository.findAll().stream().filter(queue -> queue.getStatus() != status).map(queue -> {
			return queue.toModel();
		}).toList();
	}

	@Override
	public void kitchenCompletedOrder(Long idOrder) {
		QueueEntity queueEntity = queueRepository.findByIdOrder(idOrder);
		queueEntity.setStatus(QueueEnums.PRONTO);
		queueRepository.save(queueEntity);
	}
	
	@Override
	public void orderWithdrawn(Long idOrder) {
		QueueEntity queueEntity = queueRepository.findByIdOrder(idOrder);
		queueEntity.setStatus(QueueEnums.FINALIZADO);
		queueEntity.setFinishedAt(LocalDateTime.now());
		queueRepository.save(queueEntity);
	}

}
