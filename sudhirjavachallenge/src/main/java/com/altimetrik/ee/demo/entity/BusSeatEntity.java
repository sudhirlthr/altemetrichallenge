package com.altimetrik.ee.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "busseat")
public class BusSeatEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonManagedReference
	@ManyToOne
	private BusEntity bus;
	
	public BusSeatEntity() {
		// TODO Auto-generated constructor stub
	}
	
	

	public BusSeatEntity(Long id, BusEntity bus) {
		this.id = id;
		this.bus = bus;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public BusEntity getBus() {
		return bus;
	}



	public void setBus(BusEntity bus) {
		this.bus = bus;
	}
	
	
}
