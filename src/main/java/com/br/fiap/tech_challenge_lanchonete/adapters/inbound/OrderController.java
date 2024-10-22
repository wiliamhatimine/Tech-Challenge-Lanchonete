package com.br.fiap.tech_challenge_lanchonete.adapters.inbound;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.OrdersAdapter;
import com.br.fiap.tech_challenge_lanchonete.adapters.outbound.dto.ProductDTO;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Order;
import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

@RestController
@RequestMapping("/order/api/v1")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrdersAdapter ordersAdapter;

	@PostMapping("/create")
	public ResponseEntity<Order> createProduct(@RequestParam(required = false) Long idCustomer,
			@RequestBody Map<Product, Integer> products) {
		Order order = new Order();
		try {
			order = ordersAdapter.saveOrder(Objects.nonNull(idCustomer) ? idCustomer : null, products);
			logger.info("Pedido realizado com sucesso");
		} catch (Exception e) {
			logger.error("Erro ao cadastrar");
			throw e;
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(order);
	}

	public static void main(String[] args) throws JsonProcessingException {
		
		// List<Map<Product, Integer>> products = new ArrayList<>();
		byte b = 10;
		Product product = new Product(1l, "nome", null, null, "description", b);
		Product product2 = new Product(2l, "nome2", null, null, "description2", b);
		Map<Product, Integer> mapProducts = new LinkedHashMap<Product, Integer>();
		mapProducts.put(product, 2);
		mapProducts.put(product2, 2);
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProduct(mapProducts);

		Gson gson = new Gson();
		String json = gson.toJson(productDTO);
		System.out.println(json);

	}
}
