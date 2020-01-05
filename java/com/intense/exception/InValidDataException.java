package com.intense.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InValidDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(InValidDataException.class);

	public InValidDataException(String message) {
		super(message);
		log.info("InValidDataException : " + message);
	}

}
