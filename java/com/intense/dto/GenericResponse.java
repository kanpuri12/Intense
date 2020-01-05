package com.intense.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GenericResponse {
	private String statusCode;
	private Object statusDesc;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date respTime;

	private Object responseData;

	public GenericResponse() {
		// TODO Auto-generated constructor stub
	}

	public GenericResponse(String statusDesc, String statusCode) {
		super();
		this.statusDesc = statusDesc;
		this.statusCode = statusCode;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	public Date getRespTime() {
		return new Date();
	}

	public void setRespTime(Date respTime) {
		this.respTime = respTime;
	}

	public Object getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(Object statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
