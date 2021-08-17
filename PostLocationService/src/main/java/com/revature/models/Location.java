package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations")
@NoArgsConstructor
public @Data class Location {

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String city;
	
	private String state; 

	public Location(String city, String state) {
		this.city = city;
		this.state = state; 
	}

	public Location(Integer locationId, String city, String state) { 
		this.id = locationId; 
		this.city = city; 
		this.state = state; 
	}
	
	

}
