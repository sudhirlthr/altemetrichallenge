
package com.altimetrik.ee.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "operator")
public class OperatorEntity {

	@Id
	private Long operatorId;

	@NotNull
	private String name;
	
	@JsonBackReference
	@OneToMany(mappedBy = "operator")
	private Set<BusEntity> buses;

	public OperatorEntity() {
	}

	public OperatorEntity(String name, Set<BusEntity> buses) { 
		this.name = name; 
	    this.buses = buses;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BusEntity> getBuses() {
		return buses;
	}

	public void setBuses(Set<BusEntity> buses) {
		this.buses = buses;
	}
  
  }
