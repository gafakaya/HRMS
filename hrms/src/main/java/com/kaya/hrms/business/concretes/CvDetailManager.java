package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.CvDetailService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.CvDetailDao;
import com.kaya.hrms.entities.concretes.CvDetail;

@Service
public class CvDetailManager implements CvDetailService {
	
	private CvDetailDao cvDetailDao;

	@Autowired
	public CvDetailManager(CvDetailDao cvDetailDao) {
		this.cvDetailDao = cvDetailDao;
	}

	@Override
	public DataResult<CvDetail> getByJobSeeker_id(int jobSeeker) {
		CvDetail result = this.cvDetailDao.getByJobSeeker_id(jobSeeker);
		return new SuccessDataResult<CvDetail>(result);
	}

	@Override
	public DataResult<List<CvDetail>> getAll() {
		List<CvDetail> result = this.cvDetailDao.findAll();
		return new SuccessDataResult<List<CvDetail>>(result);
	}

	@Override
	public Result add(CvDetail cvDetail) {
		this.cvDetailDao.save(cvDetail);
		return new SuccessResult();
	}

	
}
