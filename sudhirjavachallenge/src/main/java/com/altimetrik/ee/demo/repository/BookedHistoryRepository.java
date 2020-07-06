package com.altimetrik.ee.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.ee.demo.entity.BookedSeatEntity;

@Repository
public interface BookedHistoryRepository extends JpaRepository<BookedSeatEntity, Long>{
	List<BookedSeatEntity> findByUsername(String username);
}
