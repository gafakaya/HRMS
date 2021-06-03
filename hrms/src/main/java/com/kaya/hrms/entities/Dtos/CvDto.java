package com.kaya.hrms.entities.Dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaya.hrms.entities.concretes.JobSeeker;
import com.kaya.hrms.entities.concretes.JobSeekerAbility;
import com.kaya.hrms.entities.concretes.JobSeekerLanguage;
import com.kaya.hrms.entities.concretes.JobSeekerSchoolDepartment;
import com.kaya.hrms.entities.concretes.JobSeekerWorkplaceTitle;
import com.kaya.hrms.entities.concretes.SocialMedia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	@JsonIgnore
	private JobSeeker jobSeeker;
	
	private List<JobSeekerSchoolDepartment> jobSeekerSchoolDepartments;
	
	private List<JobSeekerWorkplaceTitle> jobSeekerWorkplaceTitles;
	
	private List<JobSeekerLanguage> jobSeekerLanguages;
	
	private List<JobSeekerAbility> jobSeekerAbilities;
	
	private List<SocialMedia> socialMedias;
	

	
}
