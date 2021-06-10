package com.kaya.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobAdvertisementApplicationService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobAdvertisementApplicationDao;
import com.kaya.hrms.entities.concretes.JobAdvertisementApplication;

@Service
public class JobAdvertisementApplicationManager implements JobAdvertisementApplicationService {

	private JobAdvertisementApplicationDao jobAdvertisementApplicationDao;
	
	@Autowired
	public JobAdvertisementApplicationManager(JobAdvertisementApplicationDao jobAdvertisementApplicationDao) {
		this.jobAdvertisementApplicationDao = jobAdvertisementApplicationDao;
	}

	@Override
	public DataResult<List<JobAdvertisementApplication>> getAll() {
		List<JobAdvertisementApplication> result = this.jobAdvertisementApplicationDao.findAll();
		return new SuccessDataResult<List<JobAdvertisementApplication>>(result);
	}

	@Override
	public Result add(JobAdvertisementApplication jobAdvertisementApplication) {
		jobAdvertisementApplication.setCreatedAt(LocalDateTime.now());
		this.jobAdvertisementApplicationDao.save(jobAdvertisementApplication);
		return new SuccessResult();
	}

}
