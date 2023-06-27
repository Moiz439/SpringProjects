package com.dtoexample.dtoexampleproject.exceptionHandler;


// Create a UserNotfoundException class and extends Exception Class.
public class UserNotfoundException extends Exception{
	

	public UserNotfoundException(String message) // create a aConstructor to display the Message
	{
		super(message);
	}
}
