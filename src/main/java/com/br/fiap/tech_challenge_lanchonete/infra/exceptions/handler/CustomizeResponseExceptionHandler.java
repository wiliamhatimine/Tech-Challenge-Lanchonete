package com.br.fiap.tech_challenge_lanchonete.infra.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.fiap.tech_challenge_lanchonete.infra.exceptions.ExceptionResponse;
import com.br.fiap.tech_challenge_lanchonete.infra.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class CustomizeResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(ProductNotFoundException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MultipartException.class)
	public final ResponseEntity<Object> handleAllExceptions(MultipartException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), HttpStatus.BAD_REQUEST.getReasonPhrase());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
