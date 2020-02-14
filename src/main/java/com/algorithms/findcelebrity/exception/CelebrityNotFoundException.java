package com.algorithms.findcelebrity.exception;

public class CelebrityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CelebrityNotFoundException(String message){
        super(message);
    }

}
