package com.br.fiap.tech_challenge_lanchonete.adapters.outbound.converter;

import java.io.IOException;

import com.br.fiap.tech_challenge_lanchonete.application.core.domain.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomProductSerializer extends StdSerializer<Product>{

    public CustomProductSerializer() {
        this(null);
    }
	
	public CustomProductSerializer(Class<Product> t) {
		super(t);
	}

	@Override
	public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
	        jsonGenerator.writeStartObject();
	        jsonGenerator.writeStringField("name", product.getName());
	        jsonGenerator.writeStringField("description", product.getDescription());
	        jsonGenerator.writeEndObject();
	    }

}
