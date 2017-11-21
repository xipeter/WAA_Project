package mum.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found under thiscategory.")
public class OrderNotFoundException extends RuntimeException {
	
	private String message;
	
	public OrderNotFoundException(String message) {
		this.message = message;
	}

}
