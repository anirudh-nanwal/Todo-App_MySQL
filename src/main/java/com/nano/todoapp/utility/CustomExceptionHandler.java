package com.nano.todoapp.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nano.todoapp.pojo.CustomException;
import com.nano.todoapp.pojo.TxnStatus;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public TxnStatus handleCustomException(CustomException ex) {
		Map<String, Object> errorResponse = new HashMap<String, Object>();
		errorResponse.put("message", ex.getMessage());
		errorResponse.put("statusCd", ex.getStatusCd());
		errorResponse.put("status", ex.getStatus());
		
		return new TxnStatus(errorResponse, ex.getStatusCd(), ex.getStatus());
	}
}
