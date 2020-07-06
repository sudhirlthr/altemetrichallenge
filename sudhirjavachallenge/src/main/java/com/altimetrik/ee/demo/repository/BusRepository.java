
package com.altimetrik.ee.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.ee.demo.entity.BusEntity;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Long> {
	List<BusEntity> findAllBySourceAndDestinationAndDeparturetime(String source, String destination, LocalDate traveldate);

	List<BusEntity> findAllBySourceAndDestinationAndDeparturetimeBetween(String source, String destination,
			LocalDate traveldate, LocalDate returndate);
}
