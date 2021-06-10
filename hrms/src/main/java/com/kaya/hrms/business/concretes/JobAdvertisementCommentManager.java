package com.kaya.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobAdvertisementApplicationService;
import com.kaya.hrms.business.abstracts.JobAdvertisementCommentService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobAdvertisementCommentDao;
import com.kaya.hrms.entities.concretes.JobAdvertisementApplication;
import com.kaya.hrms.entities.concretes.JobAdvertisementComment;

@Service
public class JobAdvertisementCommentManager implements JobAdvertisementCommentService {

	private JobAdvertisementCommentDao jobAdvertisementCommentDao;
	
	@Autowired
	public JobAdvertisementCommentManager(
			JobAdvertisementCommentDao jobAdvertisementCommentDao) {
		this.jobAdvertisementCommentDao = jobAdvertisementCommentDao;
	}

	@Override
	public DataResult<List<JobAdvertisementComment>> getAll() {
		List<JobAdvertisementComment> result = this.jobAdvertisementCommentDao.findAll();
		return new SuccessDataResult<List<JobAdvertisementComment>>(result);
	}

	@Override
	public Result add(JobAdvertisementComment jobAdvertisementComment) {
		jobAdvertisementComment.setCreatedAt(LocalDateTime.now());
		this.jobAdvertisementCommentDao.save(jobAdvertisementComment);
		return new SuccessResult();
	}

}
