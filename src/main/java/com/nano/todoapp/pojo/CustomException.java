package com.nano.todoapp.pojo;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private int statusCd;
	private HttpStatus status;

	public CustomException(String message, int statusCd, HttpStatus status) {
		super();
		this.message = message;
		this.statusCd = statusCd;
		this.status = status;
	}

	public CustomException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(int statusCd) {
		this.statusCd = statusCd;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomException [message=" + message + ", statusCd=" + statusCd + ", status=" + status + "]";
	}
	
}
