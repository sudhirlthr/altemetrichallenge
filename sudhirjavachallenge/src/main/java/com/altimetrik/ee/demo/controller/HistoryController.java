package com.altimetrik.ee.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.ee.demo.entity.BookedSeatEntity;
import com.altimetrik.ee.demo.service.BookedSeatService;

@RestController
@RequestMapping("/history")
public class HistoryController {
	
	private BookedSeatService bookedSeatService;
	
	public HistoryController(BookedSeatService bookedSeatService) {
		this.bookedSeatService = bookedSeatService;
	}
	
	@GetMapping("/username")
	public List<BookedSeatEntity> getAllBookedHistoryByUsername(@RequestParam("username") String username){
		return bookedSeatService.findAllByUsername(username);
	}
}
