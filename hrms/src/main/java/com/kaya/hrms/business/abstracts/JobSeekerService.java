package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<JobSeeker> getById(int jobSeekerId);
	
	Result add(JobSeeker jobSeeker);
	
	Result delete(int jobSeekerId);
	
//	Result update(JobSeeker jobSeeker);
	
	Result checkUserExists(String email, String nationalityId);
	
	
}
