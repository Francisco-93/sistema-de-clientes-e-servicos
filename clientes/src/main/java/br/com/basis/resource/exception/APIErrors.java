package br.com.basis.resource.exception;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class APIErrors {
	
	@Getter
	private List<String> errors;
	
	public APIErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public APIErrors(String msg) {
		this.errors = Arrays.asList(msg);
	}
}
