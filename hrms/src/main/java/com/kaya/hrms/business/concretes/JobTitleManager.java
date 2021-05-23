package com.kaya.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobTitleService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.business.BusinessRules;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.ErrorDataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobTitleDao;
import com.kaya.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		List<JobTitle> result = this.jobTitleDao.findAll();
		return new SuccessDataResult<List<JobTitle>>(result, Messages.JOB_TITLES_LISTED) ;
	}

	@Override
	public DataResult<JobTitle> getById(int jobTitleId) {
		
//	TODO: Business Make Engine.
//		if (BusinessRules.Run()) {
//			return 
//		}		
		
		Optional<JobTitle> jobTitle = this.jobTitleDao.findById(jobTitleId);
		boolean jobTitlesExists = jobTitle.isPresent();
		
		if (!jobTitlesExists) {
			return new ErrorDataResult<JobTitle>(Messages.JOB_TITLE_NOT_FOUND);
		}
		
		JobTitle result = jobTitle.get();		
		
		return new SuccessDataResult<JobTitle>(result, Messages.JOB_TITLES_LISTED_BYID);
	}

	@Override
	public Result add(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult(Messages.JOB_TITLE_ADDED);
	}

	@Override
	public Result delete(int jobTitleId) {
		this.jobTitleDao.deleteById(jobTitleId);
		return new SuccessResult(Messages.JOB_TITLE_DELETED);
	}

	@Override
	public Result update(int jobTitleId, String jobTitleName) {
		JobTitle jobTitle = getById(jobTitleId).getData();
		jobTitle.setTitle(jobTitleName);
		return new SuccessResult(Messages.JOB_TITLE_UPDATED);
	}
	
}
