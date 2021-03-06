package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.JobAdvertisementDtos.JobAdvertisementAddDto;
import com.kaya.hrms.entities.Dtos.JobAdvertisementDtos.JobAdvertisementUpdateDto;
import com.kaya.hrms.entities.Dtos.JobAdvertisementDtos.JobAdvertisementWithCompanyDto;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getByEnable();
	
	DataResult<List<JobAdvertisement>> getByEnable(int pageNo, int pageSize);

	DataResult<List<JobAdvertisement>> getByEnableSortedAsc();

	DataResult<List<JobAdvertisement>> getByEnableSortedDesc();

	DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementWithCompany();
	
	DataResult<JobAdvertisementWithCompanyDto> getJobAdvertisementWithCompanyById(int jobAdvertisementId);
	
	DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementsNonConfirm();
	
	DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementWithCompanyOrderByCreatedAt();

	DataResult<List<JobAdvertisement>> getByEnableTrueAndCompanyName(String companyName);
	

	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	
	Result update(int jobAdvertisementId, JobAdvertisementUpdateDto jobAdvertisementUpdateDto);
	
	Result delete(int jobAdvertisementId);
	
	Result confirmation(int jobAdvertisementId, boolean confirm);

}
