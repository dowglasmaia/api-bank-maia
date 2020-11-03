package com.maia.bank.services.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourcesExceptionHandle {
	
	@ExceptionHandler(ObjectNotFoundExecption.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExecption e, HttpServletRequest request ){
		StandardError err = StandardError.builder()
				.timestamp(System.currentTimeMillis())
				.status(HttpStatus.NOT_FOUND.value())
				.error("Recurso não encontrado!")
				.message(e.getMessage())
				.path(request.getRequestURI())
				.build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);		
	}
	
	@ExceptionHandler(BalanceExecption.class)
	public ResponseEntity<StandardError> balanceError(BalanceExecption e, HttpServletRequest request ){
		StandardError err = StandardError.builder()
				.timestamp(System.currentTimeMillis())
				.status(HttpStatus.NOT_FOUND.value())
				.error("Operação Falhou!")
				.message(e.getMessage())
				.path(request.getRequestURI())
				.build();
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(err);		
	}
	
	@ExceptionHandler(ValidationOperationExecption.class)
	public ResponseEntity<StandardError> operationFail(ValidationOperationExecption e, HttpServletRequest request ){
		StandardError err = StandardError.builder()
				.timestamp(System.currentTimeMillis())
				.status(HttpStatus.NOT_FOUND.value())
				.error("Error de Validação!")
				.message(e.getMessage())
				.path(request.getRequestURI())
				.build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);		
	}

}
