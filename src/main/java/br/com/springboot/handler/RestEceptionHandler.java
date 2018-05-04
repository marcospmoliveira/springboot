package br.com.springboot.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.springboot.error.ResourceNotFoundDetails;
import br.com.springboot.error.ResourceNotFoundException;

@ControllerAdvice
public class RestEceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {
		ResourceNotFoundDetails rfnDetails = ResourceNotFoundDetails
				.builder()
				.withTimestamp(new Date().getTime())
				.withTitle("Resource not found")
				.withDetail(rfnException.getMessage())
				.withStatus(HttpStatus.NOT_FOUND.value())
				.withDeveloperMessage(rfnException.getClass().getName())
				.build();
		return new ResponseEntity<>(rfnDetails, HttpStatus.NOT_FOUND);
	}
}
