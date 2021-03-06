package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerWorkplaceTitle;

public interface JobSeekerWorkplaceTitleService {

	DataResult<List<JobSeekerWorkplaceTitle>> getAll();
	
	DataResult<List<JobSeekerWorkplaceTitle>> getByJobSeeker_id(int jobSeekerId);

	Result add(JobSeekerWorkplaceTitle jobSeekerWorkplaceTitle);

}
