package com.intense.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.intense.dto.GenericResponse;
import com.intense.util.StatusCodeConstants;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<GenericResponse> customHandleNotFound(Exception ex) {
		log.info("ResourceNotFoundException Exception handler");
		GenericResponse errors = new GenericResponse();
		errors.setStatusCode(StatusCodeConstants.ERROR_RESOURCE_NOT_FOUND);
		errors.setStatusDesc(ex.getMessage());
		log.info("Error is " + errors);
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(UnknownException.class)
	public ResponseEntity<GenericResponse> customHandleUnknown(Exception ex) {
		log.info("UnkonwnException Exception handler");
		GenericResponse errors = new GenericResponse();
		errors.setStatusCode(StatusCodeConstants.ERROR_UNKNOWN);
		errors.setStatusDesc(ex.getMessage());
		log.info("Error is " + errors);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidDateException.class)
	public ResponseEntity<GenericResponse> customHandleInvalidDate(Exception ex) {
		log.info("InvalidDateException Exception handler");
		GenericResponse errors = new GenericResponse();
		errors.setStatusCode(StatusCodeConstants.ERROR_INVALID_DATE);
		errors.setStatusDesc(ex.getMessage());
		log.info("Error is " + errors);
		return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);

	}

	@ExceptionHandler(RecordAlreadyPresentExecption.class)
	public ResponseEntity<GenericResponse> customHandleRecordFound(Exception ex) {
		log.info("RecordAlreadyPresentExecption Exception handler");
		GenericResponse errors = new GenericResponse();
		errors.setStatusCode(StatusCodeConstants.ERROR_UNKNOWN);
		errors.setStatusDesc(ex.getMessage());
		log.info("Error is " + errors);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		GenericResponse response = new GenericResponse();
		response.setStatusCode(StatusCodeConstants.ERROR_UNKNOWN);
		response.setStatusDesc(errors);

		return new ResponseEntity<>(response, headers, status);

	}

}
