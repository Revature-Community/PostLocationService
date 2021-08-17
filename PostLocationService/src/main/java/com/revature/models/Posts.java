package com.revature.models;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
public @Data class Posts{

	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "content", columnDefinition = "text")
	private String content;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Location.class)
	@JoinColumn(name = "location_id", nullable = false)
	private Location locationId;

	@Enumerated(EnumType.STRING)
	@Column(name = "category_type")
	private CategoryType categoryType;
	
	@Column(name = "date")
	private Date date;

	//Constructor
	//========================
    @Column(name = "userId")
    private Integer userId;
    
    @Column(name="username")
    private String username;
    
    @Column(name="active_state")
    private boolean activeState;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pin_status_id", nullable = false)
    private PinStatus pinStatus;
    
	public Posts(String title, String content, Location locationId, CategoryType categoryType) {
		this.title = title;
		this.content = content;
		this.locationId = locationId;
		this.categoryType = categoryType;
	}

	
}
