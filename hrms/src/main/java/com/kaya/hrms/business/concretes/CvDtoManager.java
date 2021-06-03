package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.CvDtoService;
import com.kaya.hrms.business.abstracts.JobSeekerAbilityService;
import com.kaya.hrms.business.abstracts.JobSeekerLanguageService;
import com.kaya.hrms.business.abstracts.JobSeekerSchoolDepartmentService;
import com.kaya.hrms.business.abstracts.JobSeekerService;
import com.kaya.hrms.business.abstracts.JobSeekerWorkplaceTitleService;
import com.kaya.hrms.business.abstracts.SocialMediaService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.CvDto;

@Service
public class CvDtoManager implements CvDtoService {
	
	private JobSeekerWorkplaceTitleService jobSeekerWorkplaceTitleService;
	private JobSeekerSchoolDepartmentService jobSeekerSchoolDepartmentService;
	private JobSeekerLanguageService jobSeekerLanguageService;
	private JobSeekerAbilityService jobSeekerAbilityService;
	private SocialMediaService socialMediaService;
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public CvDtoManager(
			JobSeekerWorkplaceTitleService jobSeekerWorkplaceTitleService,
			JobSeekerSchoolDepartmentService jobSeekerSchoolDepartmentService,
			JobSeekerLanguageService jobSeekerLanguageService,
			JobSeekerAbilityService jobSeekerAbilityService,
			SocialMediaService socialMediaService,
			JobSeekerService jobSeekerService) {
		this.jobSeekerWorkplaceTitleService = jobSeekerWorkplaceTitleService;
		this.jobSeekerSchoolDepartmentService = jobSeekerSchoolDepartmentService;
		this.jobSeekerLanguageService = jobSeekerLanguageService;
		this.jobSeekerAbilityService = jobSeekerAbilityService;
		this.socialMediaService = socialMediaService;
		this.jobSeekerService = jobSeekerService;
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		
		
		return null;
	}
	
	@Override
	public DataResult<CvDto> getByJobSeekerId(int jobSeekerId) {
		
		CvDto cvDto = new CvDto(
				this.jobSeekerService.getById(jobSeekerId),
				this.jobSeekerSchoolDepartmentService.getByJobSeeker_jobSeekerIdOrderByDateOfGraduationDesc(jobSeekerId),
				this.jobSeekerWorkplaceTitleService.getByJobSeeker_id(jobSeekerId),
				this.jobSeekerLanguageService.getByJobSeeker_id(jobSeekerId),
				);
		
		return null;
	}

	@Override
	public Result add(CvDto cvDto) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
