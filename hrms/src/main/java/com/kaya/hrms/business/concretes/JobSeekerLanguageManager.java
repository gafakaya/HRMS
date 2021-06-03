package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobSeekerLanguageService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import com.kaya.hrms.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

	private JobSeekerLanguageDao jobSeekerLanguageDao;
	
	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getAll() {
		List<JobSeekerLanguage> result = this.jobSeekerLanguageDao.findAll();
		return new SuccessDataResult<List<JobSeekerLanguage>>(result);
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getByJobSeeker_id(int jobSeekerId) {
		List<JobSeekerLanguage> result = this.jobSeekerLanguageDao.getByJobSeeker_id(jobSeekerId);
		return new SuccessDataResult<List<JobSeekerLanguage>>(result);
	}
	
	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		this.jobSeekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult();
	}


}
