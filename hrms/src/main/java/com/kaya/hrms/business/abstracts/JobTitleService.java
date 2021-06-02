package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();

	DataResult<JobTitle> getById(int jobTitleId);
	
	DataResult<JobTitle> getByName(String jobTitleName);

	Result add(JobTitle jobTitle);
	
	Result delete(int jobTitleId);
	
	Result update(int jobTitleId, String jobTitleName);
	
}
