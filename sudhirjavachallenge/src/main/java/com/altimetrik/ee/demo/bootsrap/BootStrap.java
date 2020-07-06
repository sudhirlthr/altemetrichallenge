package com.altimetrik.ee.demo.bootsrap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.altimetrik.ee.demo.entity.BusEntity;
import com.altimetrik.ee.demo.entity.BusSeatEntity;
import com.altimetrik.ee.demo.entity.OperatorEntity;
import com.altimetrik.ee.demo.repository.BusRepository;
import com.altimetrik.ee.demo.repository.Operatorrepository;
import com.altimetrik.ee.demo.repository.SeatRepository;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private SeatRepository seatRepository;
	private BusRepository busRepository;
	private Operatorrepository operatorrepository;
	
	public BootStrap(SeatRepository seatRepository, BusRepository busRepository, Operatorrepository operatorrepository) {
		this.busRepository = busRepository;
		this.seatRepository = seatRepository;
		this.operatorrepository = operatorrepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		BusSeatEntity seat = new BusSeatEntity();
		seatRepository.save(seat);
		
		OperatorEntity operator = new OperatorEntity();
		operator.setName("Chennai Bus service");
		operator.setOperatorId(645654l);
		operator.setBuses(new HashSet<BusEntity>());
		operator = operatorrepository.save(operator);
		
		List<BusSeatEntity> busSeats = new ArrayList<>();
		busSeats.add(seat);		
		
		BusEntity bus = new BusEntity("Hyd", "Mas", "123",  LocalDateTime.of(2020, 06, 20, 11, 45).toLocalDate(), LocalDateTime.of(2020, 06, 20, 9, 45).toLocalDate(), 2l, 5999.00, operator, busSeats);
		busRepository.save(bus);
		
		seat.setBus(bus);
		seatRepository.save(seat);
		
		
	}

	

}
