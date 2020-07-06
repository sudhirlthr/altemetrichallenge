package com.altimetrik.ee.demo.exception;

public class SeatNotFoundException extends RuntimeException{
	public SeatNotFoundException(Long busId, Long seatId) {
		super(String.format("Seat got filled for bus %d", busId));
	}
}
