package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.CvDetail;

public interface CvDetailService {
	
	DataResult<List<CvDetail>> getAll();
	
	DataResult<CvDetail> getByJobSeeker_id(int jobSeeker);

	Result add(CvDetail cvDetail);
	
}
