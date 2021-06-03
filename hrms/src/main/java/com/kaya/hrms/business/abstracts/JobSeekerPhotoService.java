package com.kaya.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerPhoto;

public interface JobSeekerPhotoService {
	
	DataResult<List<JobSeekerPhoto>> getAll();
	
	DataResult<JobSeekerPhoto> getByJobSeeker_id(int jobSeekerId);
	
	Result add(JobSeekerPhoto jobSeekerPhoto);
	
	Result add(JobSeekerPhoto jobSeekerPhoto, MultipartFile file);

}
