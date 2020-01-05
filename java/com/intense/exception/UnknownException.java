package com.intense.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnknownException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UnknownException.class);
	
    public UnknownException(String message) {
        super(message);
        this.printStackTrace();
        log.info("UnkonwnException " + message);
    }
	
}
