
package com.altimetrik.ee.demo.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bus")
public class BusEntity implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 6253061963436110382L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long busId;

	@NotNull
	private String source;

	@NotNull
	private String destination;

	private String busnumber;

	private LocalDate departuretime;

	private LocalDate arrivaltime;

	private Long duration;

	private Double price;
	
	@JsonManagedReference
	@ManyToOne
	private OperatorEntity operator;
	
	@JsonBackReference
	@OneToMany(mappedBy = "bus")
	List<BusSeatEntity> seats = new ArrayList<BusSeatEntity>(50);// assuming 50 seats are initially 

	public BusEntity() {
	}

	public BusEntity(@NotNull String source, @NotNull String destination, 
			String busnumber, LocalDate departureTime, LocalDate arrivalTime, Long duration, Double price,
			OperatorEntity operator, List<BusSeatEntity> seats) {
		this.source = source;
		this.destination = destination;
		this.busnumber = busnumber;
		this.departuretime = departureTime;
		this.arrivaltime = arrivalTime;
		this.duration = duration;
		this.price = price;
		this.operator = operator;
		this.seats = seats;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public OperatorEntity getOperator() {
		return operator;
	}

	public void setOperator(OperatorEntity operator) {
		this.operator = operator;
	}

	public List<BusSeatEntity> getSeats() {
		return seats;
	}

	public void setSeats(List<BusSeatEntity> seats) {
		this.seats = seats;
	}

	public LocalDate getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(LocalDate departuretime) {
		this.departuretime = departuretime;
	}

	public LocalDate getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(LocalDate arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
