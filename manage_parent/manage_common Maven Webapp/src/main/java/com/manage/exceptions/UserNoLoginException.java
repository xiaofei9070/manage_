package com.manage.exceptions;

public class UserNoLoginException extends Exception{
	
	public UserNoLoginException() {
	}
	public UserNoLoginException(String message) {
		super(message);
	}
}
