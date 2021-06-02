package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers_workplaces_titles")
public class JobSeekerWorkplaceTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_seeker_work_id")
	private int jobSeekerWorkId;

	@Column(name="date_of_entry")
	private LocalDate dateOfEntry;
	
	@Column(name="date_of_quit")
	private LocalDate dateOfQuit;
	
	@ManyToOne
	@JoinColumn(name="workplaces_id")
	private Workplace workplace;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	
	
}
