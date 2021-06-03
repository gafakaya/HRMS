package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobSeekerWorkplaceTitleService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobSeekerWorkplaceTitleDao;
import com.kaya.hrms.entities.concretes.JobSeekerWorkplaceTitle;

@Service
public class JobSeekerWorkplaceTitleManager implements JobSeekerWorkplaceTitleService {

	private JobSeekerWorkplaceTitleDao jobSeekerWorkplaceTitleDoa;
	
	@Autowired
	public JobSeekerWorkplaceTitleManager(JobSeekerWorkplaceTitleDao jobSeekerWorkplaceTitleDoa) {
		this.jobSeekerWorkplaceTitleDoa = jobSeekerWorkplaceTitleDoa;
	}

	@Override
	public DataResult<List<JobSeekerWorkplaceTitle>> getAll() {
		List<JobSeekerWorkplaceTitle> result = this.jobSeekerWorkplaceTitleDoa.findAll();
		return new SuccessDataResult<List<JobSeekerWorkplaceTitle>>(result);
	}

	@Override
	public DataResult<List<JobSeekerWorkplaceTitle>> getByJobSeeker_id(int jobSeekerId) {
		List<JobSeekerWorkplaceTitle> result = this.jobSeekerWorkplaceTitleDoa.getByJobSeeker_id(jobSeekerId);
		return new SuccessDataResult<List<JobSeekerWorkplaceTitle>>(result);
	}

	@Override
	public Result add(JobSeekerWorkplaceTitle jobSeekerWorkplaceTitle) {
		this.jobSeekerWorkplaceTitleDoa.save(jobSeekerWorkplaceTitle);
		return new SuccessResult();
	}

}
