package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(
		{"hibernateLazyInitializer",
			"handler",
			"jobAdvertisementComments",
			"jobAdvertisementApplications"})
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;

	@Column(name="application_dateline")
	private LocalDate applicationDeadline;

	@Column(name="enable")
	private boolean enable;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="job_advertisement_like")
	private int like;

	@JsonIgnore
	@OneToMany(mappedBy = "jobAdvertisement")
	private List<JobAdvertisementComment> jobAdvertisementComments;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobAdvertisement")
	private List<JobAdvertisementApplication> jobAdvertisementApplications;
	
	@ManyToOne
	@JoinColumn(name="work_type_id")
	private WorkType workType;

	@ManyToOne
	@JoinColumn(name="work_time_id")
	private WorkTime workTime;
	
	@Column(name="confirm")
	private boolean confirm;
	
	
}
