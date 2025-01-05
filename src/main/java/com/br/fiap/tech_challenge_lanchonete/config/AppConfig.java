package com.br.fiap.tech_challenge_lanchonete.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.fiap.tech_challenge_lanchonete.application.usecases.orders.OrderUseCase;
import com.br.fiap.tech_challenge_lanchonete.application.usecases.payments.PaymentUseCase;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.jpa.orders.OrderRepositoryJpaGateway;
import com.br.fiap.tech_challenge_lanchonete.infra.persistence.jpa.payments.PaymentsRepositoryJpaGateway;

@Configuration
public class AppConfig {

	@Bean("payment-jpa")
	public PaymentUseCase paymentUseCase(PaymentsRepositoryJpaGateway paymentsRepositoryJpaGateway) {
		return new PaymentUseCase(paymentsRepositoryJpaGateway);
		
	}
	
	@Bean("order-jpa")
	public OrderUseCase orderUseCase(OrderRepositoryJpaGateway orderRepositoryJpaGateway) {
		return new OrderUseCase(orderRepositoryJpaGateway);
		
	}
	
}
