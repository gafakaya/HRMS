package com.kaya.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kaya.hrms.business.abstracts.JobSeekerPhotoService;
import com.kaya.hrms.core.utilities.helpers.imageHelper.ImageUploadService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobSeekerPhotoDao;
import com.kaya.hrms.entities.concretes.JobSeekerPhoto;

@Service
public class JobSeekerPhotoManager implements JobSeekerPhotoService {
	
	private JobSeekerPhotoDao jobSeekerPhotoDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public JobSeekerPhotoManager(
			JobSeekerPhotoDao jobSeekerPhotoDao,
			ImageUploadService imageUploadService) {
		this.jobSeekerPhotoDao = jobSeekerPhotoDao;
		this.imageUploadService = imageUploadService;
	}
	
	@Override
	public DataResult<List<JobSeekerPhoto>> getAll() {
		List<JobSeekerPhoto> result = this.jobSeekerPhotoDao.findAll();
		return new SuccessDataResult<List<JobSeekerPhoto>>(result);
	}

	@Override
	public DataResult<JobSeekerPhoto> getByJobSeeker_id(int jobSeekerId) {
		JobSeekerPhoto result = this.jobSeekerPhotoDao.getByJobSeeker_id(jobSeekerId);
		return new SuccessDataResult<JobSeekerPhoto>(result);
	}
	
	@Override
	public Result add(JobSeekerPhoto jobSeekerPhoto) {
		
		this.jobSeekerPhotoDao.save(jobSeekerPhoto);
		
		return new SuccessResult();
	}

	@Override
	public Result add(JobSeekerPhoto jobSeekerPhoto, MultipartFile file) {
		
		 Map<String,String> result = (Map<String,String>) this.imageUploadService.save(file).getData();
		 
	     String url = result.get("url");
		 
	     jobSeekerPhoto.setPhotoUrl(url);
		 jobSeekerPhoto.setUploadedDate(LocalDate.now());
	     
	     return add(jobSeekerPhoto);
	}

}
