package com.checkpeople.model;

import java.io.Serializable;

public class ResponseMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3721004744620271257L;
	private String message;

	public String getMessage() {
		return message;
	}

	public ResponseMessage(String message) {
		this.message = message;
	}
		
	public ResponseMessage(Exception e) {
		this.message = e.getMessage();
	}
	
	
}
