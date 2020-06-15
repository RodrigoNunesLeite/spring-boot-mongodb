package com.rodrigonunes.springbootmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rodrigonunes.springbootmongo.services.exception.ObjectNotFoundException;

/*
 * Essa notacao @ControllerAdvice indica que a classe vai 
 * monitorar os erros
 * */

@ControllerAdvice
public class ResourceExceptionHandler {
	
	/*
	 * Aqui indica que quando ocorrer a exceção ObjectNotFoundException,
	 * o response é retornado conforme abaixo
	 * */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(),status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);		
	}
	
}
