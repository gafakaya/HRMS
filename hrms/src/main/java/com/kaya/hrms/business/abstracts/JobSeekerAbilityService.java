package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerAbility;

public interface JobSeekerAbilityService {
	
	DataResult<List<JobSeekerAbility>> getAll();
	
	DataResult<List<JobSeekerAbility>> getByJobSeeker_id(int jobSeekerId);
	
	Result add(JobSeekerAbility jobSeekerAbility);
	
	Result delete(int jobSeekerAbilityId);

}
