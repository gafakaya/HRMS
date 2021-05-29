package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getByEnable();
	
	DataResult<List<JobAdvertisement>> getByEnable(int pageNo, int pageSize);

	DataResult<List<JobAdvertisement>> getByEnableSortedAsc();
	
	DataResult<List<JobAdvertisement>> getByEnableSortedDesc();

	DataResult<List<JobAdvertisement>> getByEnableTrueAndCompanyName(String companyName);

	Result add(JobAdvertisement jobAdvertisemenet);
	
	Result update(int jobAdvertisemenetId, JobAdvertisement jobAdvertisemenet);


}
