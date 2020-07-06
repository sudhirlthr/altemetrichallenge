package com.altimetrik.ee.demo.exception;

import java.time.LocalDate;

public class BusNotFoundException extends RuntimeException{
	public BusNotFoundException(String source, String destination, LocalDate traveldate) {
		super(String.format("No bus found for %s as a source city and %s as a destination for travel date %s", source, destination, traveldate));
	}
	public BusNotFoundException(String source, String destination, LocalDate traveldate, LocalDate returndate) {
		super(String.format("No bus found for %s as a source city and %s as a destination for date %s and on %s as a return date", source, destination, traveldate, returndate));
	}
	
}
