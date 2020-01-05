package com.intense.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ResourceNotFoundException.class);
	
    public ResourceNotFoundException(String message) {
        super(message);
        log.info("ResourceNotFoundException Resource not found exception" + message);
    }
	
    
  
}
