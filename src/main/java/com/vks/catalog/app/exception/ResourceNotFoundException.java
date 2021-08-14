package com.vks.catalog.app.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2553744812220227851L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
