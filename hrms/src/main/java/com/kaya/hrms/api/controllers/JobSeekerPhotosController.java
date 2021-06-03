package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kaya.hrms.business.abstracts.JobSeekerPhotoService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeeker;
import com.kaya.hrms.entities.concretes.JobSeekerPhoto;

@RestController
@RequestMapping("/api/jobSeekerPhotosController")
public class JobSeekerPhotosController {

	private JobSeekerPhotoService jobSeekerPhotoService;

	@Autowired
	public JobSeekerPhotosController(JobSeekerPhotoService jobSeekerPhotoService) {
		this.jobSeekerPhotoService = jobSeekerPhotoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int jobSeekerId,@RequestParam MultipartFile file) {
		
        JobSeekerPhoto jobSeekerPhoto = new JobSeekerPhoto();
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setId(jobSeekerId);
        jobSeekerPhoto.setJobSeeker(jobSeeker);
		
		return this.jobSeekerPhotoService.add(jobSeekerPhoto, file);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerPhoto>> getAll() {
		return this.jobSeekerPhotoService.getAll();
	}
	
	@GetMapping("/getByJobSeeker_id")
	public DataResult<JobSeekerPhoto> getByJobSeeker_id(int jobSeekerId) {
		return this.jobSeekerPhotoService.getByJobSeeker_id(jobSeekerId);
	}
	
	
	
	
}
