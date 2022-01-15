package com.uni.co2ms.exception;

public class RecordNotException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotException(String errorMessage) {
		super(errorMessage);
	}
}
