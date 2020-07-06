
package com.altimetrik.ee.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.ee.demo.entity.BookedSeatEntity;
import com.altimetrik.ee.demo.entity.BusEntity;
import com.altimetrik.ee.demo.service.BookedSeatService;
import com.altimetrik.ee.demo.service.BusService;

@RestController

@RequestMapping("/bus")
public class BusController {

	private BusService busService;
	private BookedSeatService bookedSeatService;

	public BusController(BusService busService, BookedSeatService bookedSeatService) {
		this.busService = busService;
		this.bookedSeatService = bookedSeatService;
	}

	protected static Logger logger = LoggerFactory.getLogger(ServiceController.class.getName());

	@GetMapping
	public List<BusEntity> getAllBusfromSrcToDest(@RequestParam("src") String source, @RequestParam("dest") String destination,
			@RequestParam("traveldate")  String travelDate) {
		List<BusEntity> list = busService.getAllBusBySrcAndDestAndTravelDate(source, destination, travelDate);
		return list;
	}
	
	@PostMapping("/bookseat")
	public BusEntity BookSeat(@RequestBody BookedSeatEntity seatEntity) {
		return busService.bookSeat(seatEntity);
	}
}
