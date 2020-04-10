package com.mafracompany.course.services.exceptions;

public class DataBaseException extends RuntimeException{

	static final long serialVersionUID = 1L;
	
	public DataBaseException(String msg) {
		
		super(msg);
	}
}
