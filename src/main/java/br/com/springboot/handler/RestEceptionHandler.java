package br.com.springboot.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.springboot.error.ResourceNotFoundDetails;
import br.com.springboot.error.ResourceNotFoundException;
import br.com.springboot.error.ValidationErrorDetails;

@ControllerAdvice
public class RestEceptionHandler{
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException manvException) {
		List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		ValidationErrorDetails rfnDetails = ValidationErrorDetails
				.builder()
				.withTimestamp(new Date().getTime())
				.withTitle("Field Validation Error")
				.withDetail("Field Validation Error")
				.withStatus(HttpStatus.BAD_REQUEST.value())
				.withDeveloperMessage(manvException.getClass().getName())
				.withfield(fields)
				.withfieldMessage(fieldMessages)
				.build();
		return new ResponseEntity<>(rfnDetails, HttpStatus.BAD_REQUEST);
	}
}
