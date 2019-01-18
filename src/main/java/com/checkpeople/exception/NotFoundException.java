package com.checkpeople.exception;

public class NotFoundException extends DBSimulatorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7917337732341661898L;

	public NotFoundException() {
		super("register not found");
	}
	
}
