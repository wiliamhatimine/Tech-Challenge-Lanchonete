package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.converter;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProductConverter implements AttributeConverter<List<Map<Product, Integer>>, String>{

	private ObjectMapper objectMapper = new ObjectMapper();
	
	Logger logger = LoggerFactory.getLogger(ProductConverter.class);
	
	@Override
	public String convertToDatabaseColumn(List<Map<Product, Integer>> attribute) {
		try {
			return objectMapper.writeValueAsString(attribute);
		}catch(JsonProcessingException jpe) {
			logger.warn("Cannot convert Product into String |" + jpe.getMessage());
			return null;
		}
	}

	@Override
	public List<Map<Product, Integer>> convertToEntityAttribute(String dbData) {
		try {
			return objectMapper.readValue(dbData, new TypeReference<List<Map<Product, Integer>>>() {});
		}catch(JsonProcessingException e) {
			logger.warn("Cannot convert Json into Product |" + e.getMessage() );
			return null;
		}
	}
	

}
