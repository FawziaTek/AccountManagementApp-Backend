package com.example.accountmanagementappbackend.exceptions;

import com.example.accountmanagementappbackend.configuration.GetExceptionPropertiesValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ControllerExceptionAdvice extends ResponseEntityExceptionHandler {
	
	String description="Description";
	
	String httpstatus="HttpStatus";
	
	String errorcode="ErrorCode";
	
	String success="Success";
	
	String badreguest="BAD_REQUEST";
	
	String erreur="False";
	
	
	@Autowired
	public GetExceptionPropertiesValue rpef;
	
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> map = new HashMap<>();
		{
			map.put(description, rpef.getE03());
			map.put(httpstatus, badreguest);
			map.put(errorcode, "E03");
			map.put(success, erreur);
		}
		return buildResponseEntity(map);
		
	}
	
	private ResponseEntity<Object> buildResponseEntity(Map<String, String> map) {
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) 
	@ExceptionHandler(InvalidInput.class)
	public @ResponseBody Map<String, String> invalidInput(InvalidInput emptyinput) {
		Map<String, String> map = new HashMap<>();
		{
			
			map.put(description, emptyinput.getErrorMessage()+" "+rpef.getE01());
			map.put(httpstatus, "Internal Server Error");
			map.put(errorcode, "E01");
			map.put(success, erreur);
		}

		return map;
	}

	@ExceptionHandler(value = NoSuchElementException.class)
	public @ResponseBody Map<String, String> exception(NoSuchElementException exception) {
		Map<String, String> map = new HashMap<>();

		{
			String error="";
	        if(exception.getErrorMessage()!=null) {
		        error=exception.getErrorMessage();	}
			map.put(description, error+" "+rpef.getE02());
			map.put(httpstatus, "Okay");
			map.put(errorcode, "E02");
			map.put(success, erreur);
		}

		return map;
	}

}
