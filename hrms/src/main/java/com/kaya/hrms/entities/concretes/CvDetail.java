package com.kaya.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_details")
@Entity
public class CvDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_detail_id")
	private int cvDetailId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="cv_photo_url")
	private String cvPhotoUrl;
	
	@OneToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	

}
