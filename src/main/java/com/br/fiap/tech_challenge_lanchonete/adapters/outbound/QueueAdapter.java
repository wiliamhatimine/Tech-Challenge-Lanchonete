package com.br.fiap.tech_challenge_lanchonete.adapters.outbound;

import java.util.List;

import org.springframework.stereotype.Component;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.OrderEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.entity.QueueEntity;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.OrderRepository;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.repository.QueueRepository;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.enums.QueueEnums;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.queue.Queue;
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
		List<String> listNames = orderEntity.getProducts().stream().map(product ->{
			return product.getName();
		}).toList();
		
		QueueEntity queueEntity = new QueueEntity();
		queueEntity.setIdOrder(orderId);
		queueEntity.setProductsName(listNames);
		queueEntity.setStatus(QueueEnums.PREPARO);
		return queueRepository.save(queueEntity).getJobId();
	}

	@Override
	public void moveToPreparing(Long jobId) {
		QueueEntity queueEntity = queueRepository.findById(jobId).get();
		queueEntity.setStatus(QueueEnums.EM_PREPARO);
		queueRepository.save(queueEntity);
	}

	@Override
	public Queue checkOrderStatus(Long idOrder) {
		return queueRepository.findByIdOrder(idOrder).toModel();
	}

	@Override
	public List<Queue> listClientOrders() {
		return queueRepository.findAll().stream().map(queue -> {
			return queue.toModel();
		}).toList();
	}

	@Override
	public Boolean kitchenCompletedOrder(String jobId, Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean startOrderToPrepare(String jobId, Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
