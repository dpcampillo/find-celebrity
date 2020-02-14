package com.algorithms.findcelebrity.exception;

public class WrongFormatException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public WrongFormatException(String message, Throwable ex){
        super(message, ex);
    }

}
