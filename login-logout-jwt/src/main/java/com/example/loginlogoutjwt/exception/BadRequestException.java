package com.example.loginlogoutjwt.exception;

import java.util.List;

public class BadRequestException extends RuntimeException{
	  private List<Error> errors;

	    public List<Error> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<Error> errors) {
	        this.errors = errors;
	    }

	    public BadRequestException(String message, List<Error> errors) {
	        super(message);
	        this.errors = errors;
	    }
}
