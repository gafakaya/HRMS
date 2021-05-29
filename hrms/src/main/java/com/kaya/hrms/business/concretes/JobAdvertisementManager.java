package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobAdvertisementService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(
			JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		List<JobAdvertisement> result = this.jobAdvertisementDao.findAll();
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEnable() {
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.findByEnable(true);
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_LISTED_BY_ENABLE);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEnableSorted() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "applicaitonDateline");
		
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.findByEnable(sort, true);
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_SORTED_BY_ENABLE);
	}

//	TODO: Fix it
	@Override
	public DataResult<List<JobAdvertisement>> getByEnableAndCompany_companyName(String companyName) {
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.findByEnableAndCompany_companyName(true, companyName);
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_LISTED_BY_COMPANYID_ENABLE);
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisemenet) {
		this.jobAdvertisementDao.save(jobAdvertisemenet);
		return new SuccessResult();
	}

}
