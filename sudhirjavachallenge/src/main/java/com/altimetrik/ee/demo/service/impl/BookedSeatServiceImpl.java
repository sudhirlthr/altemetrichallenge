package com.altimetrik.ee.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.entity.BookedSeatEntity;
import com.altimetrik.ee.demo.exception.BookedSeatNotFoundException;
import com.altimetrik.ee.demo.repository.BookedHistoryRepository;
import com.altimetrik.ee.demo.service.BookedSeatService;

@Service
public class BookedSeatServiceImpl implements BookedSeatService{
	
	private BookedHistoryRepository bookedSeatrepository;

	
	public BookedSeatServiceImpl(BookedHistoryRepository bookedSeatrepository) {
		this.bookedSeatrepository = bookedSeatrepository;
	}

	@Override
	public List<BookedSeatEntity> findAllByUsername(String username) {
		List<BookedSeatEntity> bookedHistory = bookedSeatrepository.findByUsername(username);
		if (bookedHistory == null) throw new BookedSeatNotFoundException(username);
		return bookedHistory;
	}

}
