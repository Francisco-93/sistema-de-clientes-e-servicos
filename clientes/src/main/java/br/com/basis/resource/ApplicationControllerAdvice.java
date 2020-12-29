package br.com.basis.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.basis.resource.exception.APIErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public APIErrors handValidationErrors(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		List<String> messages = result.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
		return new APIErrors(messages);
	}
	
	@ExceptionHandler
	public ResponseEntity handlerResponseStatusException(ResponseStatusException e) {
		String messageErro = e.getMessage();
		HttpStatus codigoStatus = e.getStatus();
		APIErrors apiErrors = new APIErrors(messageErro);
		return new ResponseEntity(apiErrors, codigoStatus);
	}
}
