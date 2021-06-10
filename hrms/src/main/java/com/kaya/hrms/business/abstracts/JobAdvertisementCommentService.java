package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobAdvertisementComment;

public interface JobAdvertisementCommentService {
	
	DataResult<List<JobAdvertisementComment>> getAll();
	
	Result add(JobAdvertisementComment jobAdvertisementComment);

}
