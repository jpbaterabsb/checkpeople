package com.checkpeople.exception;

public class IdAlreadyExistsException extends DBSimulatorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -88459492952285356L;

	public IdAlreadyExistsException() {
		super("Id already exists");
	}
	
}
