package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.CvDto;
import com.kaya.hrms.entities.Dtos.JobSeekerDtos.JobSeekerUpdateDto;
import com.kaya.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();

	DataResult<JobSeeker> getById(int jobSeekerId);
	
	DataResult<CvDto> getJobSeekerResumeByJobSeekerId(int jobSeekerId);
	
	Result add(JobSeeker jobSeeker);
	
	Result delete(int jobSeekerId);
	
	Result update(int jobSeekerId, JobSeekerUpdateDto jobSeekerUpdateDto);
	
	Result checkUserExists(String email, String nationalityId);
	
	
}
