package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaya.hrms.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(
		{"hibernateLazyInitializer",
			"handler",
			"jobSeekerSchoolDepartments",
			"jobSeekerLanguages",
			"jobSeekerAbilities",
			"jobSeekerWorkplaceTitles",
			"socialMedias",
			"jobSeekerPhotos",
			"jobAdvertisementApplications"})
public class JobSeeker extends User {

	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="nationality_id")
	private String nationalityId;
	@Column(name="day_of_birth")
	private LocalDate dayOfBirth;
	@Column(name="is_confirm")
	private boolean isConfirm;
	
	
	public JobSeeker(
			int id,
			String email,
			String password,
			LocalDate createdAt,
			String firstName,
			String lastName,
			String nationalityId,
			LocalDate dayOfBirth,
			boolean isConfirm) {
		super(id, email, password, createdAt);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dayOfBirth = dayOfBirth;
		this.isConfirm = isConfirm;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerSchoolDepartment> jobSeekerSchoolDepartments;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerLanguage> jobSeekerLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerAbility> jobSeekerAbilities;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerWorkplaceTitle> jobSeekerWorkplaceTitles;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<SocialMedia> socialMedias;

	@JsonIgnore
	@OneToOne(mappedBy = "jobSeeker")
	private CvDetail cvDetail;

	@JsonIgnore
	@OneToOne(mappedBy = "jobSeeker")
	private JobSeekerPhoto jobSeekerPhoto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobAdvertisementApplication> jobAdvertisementApplications;
	
	
	
}
