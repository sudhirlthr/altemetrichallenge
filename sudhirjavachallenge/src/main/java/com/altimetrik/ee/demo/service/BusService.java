
package com.altimetrik.ee.demo.service;

import java.util.List;

import com.altimetrik.ee.demo.entity.BookedSeatEntity;
import com.altimetrik.ee.demo.entity.BusEntity;

public interface BusService {
	List<BusEntity> getAllBusBySrcAndDestAndTravelDate(String source, String destination, String travelDate);

	List<BusEntity> getAllBusBySrcAndDestAndTravelDateBetween(String source, String destination, String travelDate,
			String returnDate);
	
	BusEntity bookSeat(BookedSeatEntity bookedSeatEntity);
}
