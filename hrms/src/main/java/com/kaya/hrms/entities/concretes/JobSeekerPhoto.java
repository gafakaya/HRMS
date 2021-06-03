package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_seeker_photos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerPhoto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="photo_id")
	private int photoId;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	@Column(name="uploaded_date")
	private LocalDate uploadedDate;
	
	@OneToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;

	
	
}
