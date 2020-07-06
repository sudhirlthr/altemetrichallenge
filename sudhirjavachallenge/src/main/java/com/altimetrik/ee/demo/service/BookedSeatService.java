package com.altimetrik.ee.demo.service;

import java.util.List;

import com.altimetrik.ee.demo.entity.BookedSeatEntity;

public interface BookedSeatService {
	public List<BookedSeatEntity> findAllByUsername(String username);
}
