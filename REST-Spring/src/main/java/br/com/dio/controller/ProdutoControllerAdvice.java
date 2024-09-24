package br.com.dio.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.dio.entity.Produto;
import br.com.dio.exception.ProductNullException;
import br.com.dio.exception.ProductPriceException;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> erro(){

		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("message", "Ocorreu um erro genérico.");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
		
	}

	@ExceptionHandler(ProductNullException.class)
	public ResponseEntity<Object> capturaErroNull(){

		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("message", "Verifique os campos do produto.");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
		
	}
	
	@ExceptionHandler(ProductPriceException.class)
	public ResponseEntity<Object> capturaPrecoMenorQ0(){

		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("message", "Verifique o preço dos produtos.");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
		
	}
	
}
