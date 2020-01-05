package com.intense.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecordAlreadyPresentExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RecordAlreadyPresentExecption.class);
	
    public RecordAlreadyPresentExecption(String message) {
        super(message);
        log.info("RecordAlreadyPresentExecption Record is already present" + message);
    }
}
