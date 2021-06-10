package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobAdvertisementApplication;

public interface JobAdvertisementApplicationService {
	
	DataResult<List<JobAdvertisementApplication>> getAll();
	
	Result add(JobAdvertisementApplication jobAdvertisementApplication);

}
