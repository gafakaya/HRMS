package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_description")
	private String eventDescription;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="date_of_event")
	private LocalDateTime dateOfEvent;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	

}
