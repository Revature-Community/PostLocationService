
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
@Table(name = "pin_status")
@NoArgsConstructor
public @Data class PinStatus {
	
	@Id
	@Column(name = "pin_status_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "pin_status")
	private String pinStatus;

	public PinStatus(Integer id, String pinStatus) {
		super();
		this.id = id;
		this.pinStatus = pinStatus;
	}
	
	
}
