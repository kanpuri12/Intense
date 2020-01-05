package com.intense.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InvalidDateException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InvalidDateException.class);
	
    public InvalidDateException(String message) {
        super(message);
    }
	
    
  
}
