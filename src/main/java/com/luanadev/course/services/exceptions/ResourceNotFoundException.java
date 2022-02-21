package com.luanadev.course.services.exceptions;

import javax.management.RuntimeErrorException;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id" + id);
	}

}
