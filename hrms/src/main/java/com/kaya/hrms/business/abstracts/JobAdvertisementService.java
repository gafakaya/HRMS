package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getByEnable();
	
	DataResult<List<JobAdvertisement>> getByEnableSorted();

	DataResult<List<JobAdvertisement>> getByEnableAndCompany_companyName(String companyName);
	
	Result add(JobAdvertisement jobAdvertisemenet);


}
