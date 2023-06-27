package com.dtoexample.dtoexampleproject.exceptionHandler;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice //it provides a ExceptionHandler to handel the Exception and Advice to handle the Exception..
public class AppExceptionHandler { // class

	@ResponseStatus(HttpStatus.BAD_REQUEST) // it display the HttpSatus Message on Postman.
	@ExceptionHandler(MethodArgumentNotValidException.class) // It is used to handel the MethodArgumentNotValidException exception.
	public Map<String,String> handelInvalidArgument(MethodArgumentNotValidException ex)
	{
		Map<String,String> m=new HashMap<>(); // Create Map Class.
		ex.getBindingResult().getFieldErrors().forEach(error->{ 
			m.put(error.getField(), error.getDefaultMessage());// map the error with default messages.
		});
		return m; // return map object.
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserNotfoundException.class) // It is used to handel the UserNotfoundException exception.
	public Map<String,String> handalBusinessException(UserNotfoundException ex)
	{
		Map<String,String> m=new HashMap<>(); // create Map Class Object.
		m.put("error Message", ex.getMessage());// put the Error Message.
		return m; // return Map Object.
	}
	
	
}
