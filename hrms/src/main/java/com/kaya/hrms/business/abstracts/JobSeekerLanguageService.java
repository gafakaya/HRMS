package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageService {

	DataResult<List<JobSeekerLanguage>> getAll();
	
	DataResult<List<JobSeekerLanguage>> getByJobSeeker_id(int jobSeekerId);
	
	Result add(JobSeekerLanguage jobSeekerLanguage);
	
}
