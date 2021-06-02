package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobSeekerAbilityService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobSeekerAbilityDao;
import com.kaya.hrms.entities.concretes.JobSeekerAbility;

@Service
public class JobSeekerAbilityManager implements JobSeekerAbilityService {

	private JobSeekerAbilityDao jobSeekerAbilityDao;
	
	@Autowired
	public JobSeekerAbilityManager(JobSeekerAbilityDao jobSeekerAbilityDao) {
		this.jobSeekerAbilityDao = jobSeekerAbilityDao;
	}

	@Override
	public DataResult<List<JobSeekerAbility>> getAll() {
		List<JobSeekerAbility> result = this.jobSeekerAbilityDao.findAll();
		return new SuccessDataResult<List<JobSeekerAbility>>(result);
	}

	@Override
	public Result add(JobSeekerAbility jobSeekerAbility) {
		this.jobSeekerAbilityDao.save(jobSeekerAbility);
		return new SuccessResult();
	}
	
	
	
}
