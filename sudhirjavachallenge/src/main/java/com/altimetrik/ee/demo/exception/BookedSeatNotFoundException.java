package com.altimetrik.ee.demo.exception;

public class BookedSeatNotFoundException extends RuntimeException{
	public BookedSeatNotFoundException(String username) {
		super(String.format("No booking for %s", username));
	}
}
