package com.kaya.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobAdvertisementService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kaya.hrms.entities.Dtos.JobAdvertisementWithCompanyDto;
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
				.getByEnableTrue();
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_LISTED_BY_ENABLE);
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByEnable(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrue(pageable).getContent();
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_PAGED_BY_ENABLE);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEnableSortedAsc() {
		
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrueOrderByApplicaitonDatelineAsc();
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_SORTED_BY_ENABLE);
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByEnableSortedDesc() {
		
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrueOrderByApplicaitonDatelineDesc();
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_SORTED_BY_ENABLE);
	}

	@Override
	public DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementWithCompany() {
		List<JobAdvertisementWithCompanyDto> result = this.jobAdvertisementDao.getJobAdvertisementWithCompany();
		return new SuccessDataResult<List<JobAdvertisementWithCompanyDto>>(result);
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByEnableTrueAndCompanyName(String companyName) {
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrueAndCompany_companyName(companyName);
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_LISTED_BY_COMPANYID_ENABLE);
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisemenet) {
		jobAdvertisemenet.setCreatedAt(LocalDate.now());
		this.jobAdvertisementDao.save(jobAdvertisemenet);
		return new SuccessResult();
	}

	@Override
	public Result update(int jobAdvertisemenetId, JobAdvertisement jobAdvertisemenet) {
		
		JobAdvertisement result = this.jobAdvertisementDao.getById(jobAdvertisemenetId);
		
		result.setEnable(jobAdvertisemenet.isEnable());
		
		if(jobAdvertisemenet.getApplicaitonDateline().isBefore(LocalDate.now())) {
			result.setEnable(false);
		}
		this.jobAdvertisementDao.save(result);
		return  new SuccessResult();
	}

}
