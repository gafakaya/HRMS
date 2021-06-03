package com.kaya.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.CvDetail;

public interface CvDetailService {
	
	DataResult<List<CvDetail>> getAll();
	
	DataResult<CvDetail> getByJobSeeker_id(int jobSeeker);

	Result add(CvDetail cvDetail);
	
//
//	Result add(CvDetail cvDetail, MultipartFile file);
	
//	,MultipartFile file
	
}
