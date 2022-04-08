package com.nano.todoapp.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TxnStatus extends ResponseEntity<Object> {

	private Object response;
	private int statusCd;
	private HttpStatus status;

	public TxnStatus(Object response, int statusCd, HttpStatus status) {
		super(response, status);
		this.response = response;
		this.statusCd = statusCd;
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public int getStatusCd() {
		return statusCd;
	}

	public void setStatusCode(int statusCode) {
		this.statusCd = statusCode;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TxnStatus [response=" + response + ", statusCd=" + statusCd + ", status=" + status + "]";
	}

}
