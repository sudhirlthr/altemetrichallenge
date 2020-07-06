
package com.altimetrik.ee.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.entity.BookedSeatEntity;
import com.altimetrik.ee.demo.entity.BusEntity;
import com.altimetrik.ee.demo.entity.BusSeatEntity;
import com.altimetrik.ee.demo.exception.BusNotFoundException;
import com.altimetrik.ee.demo.repository.BookedHistoryRepository;
import com.altimetrik.ee.demo.repository.BusRepository;
import com.altimetrik.ee.demo.repository.SeatRepository;
import com.altimetrik.ee.demo.service.BusService;

@Service
public class BusServiceImpl implements BusService {

	private BusRepository busRepository;
	private SeatRepository seatRepository;
	private BookedHistoryRepository bookedHistoryRepository;

	public BusServiceImpl(BusRepository busRepository, SeatRepository seatRepository, BookedHistoryRepository bookedHistoryRepository) {
		this.busRepository = busRepository;
		this.seatRepository = seatRepository;
		this.bookedHistoryRepository = bookedHistoryRepository;
	}

	@Override
	public List<BusEntity> getAllBusBySrcAndDestAndTravelDate(String source, String destination, String travelDate) {
		List<BusEntity> busList = busRepository.findAllBySourceAndDestinationAndDeparturetime(source, destination, LocalDate.parse(travelDate));
		if (busList == null || busList.size() == 0)
			throw new BusNotFoundException(source, destination, LocalDate.parse(travelDate));
		return busList;
	}

	@Override
	public List<BusEntity> getAllBusBySrcAndDestAndTravelDateBetween(String source, String destination,
			String travelDate, String returnDate) {
		List<BusEntity> busList = busRepository.findAllBySourceAndDestinationAndDeparturetimeBetween(source, destination,
				LocalDate.parse(returnDate), LocalDate.parse(returnDate));
		if (busList == null || busList.size() == 0)
			throw new BusNotFoundException(source, destination, LocalDate.parse(returnDate), LocalDate.parse(returnDate));
		return busList;
	}

	@Override
	public BusEntity bookSeat(BookedSeatEntity bookedSeatEntity) {
		BusEntity bus = busRepository.findById(bookedSeatEntity.getBusId())
				.orElseThrow(() -> new BusNotFoundException(bookedSeatEntity.getSource(),bookedSeatEntity.getDestination() , bookedSeatEntity.getTraveldate()));
		BusSeatEntity seat = new BusSeatEntity();
		if(bus.getSeats().size() > 0) {
			seatRepository.save(seat);
			bus.getSeats().add(seat);
		}
		bookedHistoryRepository.save(bookedSeatEntity);
		return busRepository.save(bus);
	}
  
  }
