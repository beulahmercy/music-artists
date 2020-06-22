package com.music.app.exception;

/**
 * 
 * @author Beulah Mercy
 *
 */
public class ResourceNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}