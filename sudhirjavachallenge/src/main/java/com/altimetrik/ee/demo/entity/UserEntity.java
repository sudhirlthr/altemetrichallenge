package com.altimetrik.ee.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "appuser")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	private String username;
	
	@OneToMany
	private List<BusEntity> bookedbusticket;
	public UserEntity() {	}
	public UserEntity(Long id, String username, List<BusEntity> bookedbusticket) {
		this.id = id;
		this.username = username;
		this.bookedbusticket = bookedbusticket;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<BusEntity> getBookedbusticket() {
		return bookedbusticket;
	}
	public void setBookedbusticket(List<BusEntity> bookedbusticket) {
		this.bookedbusticket = bookedbusticket;
	}
	
	
}
