package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobSeekerWorkplaceTitleService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerWorkplaceTitle;

@RestController
@RequestMapping("/api/jobSeekerWorkplaceTitlesController")
@CrossOrigin
public class JobSeekerWorkplaceTitlesController {

	private JobSeekerWorkplaceTitleService jobSeekerWorkplaceTitleService;

	@Autowired
	public JobSeekerWorkplaceTitlesController(JobSeekerWorkplaceTitleService jobSeekerWorkplaceTitleService) {
		this.jobSeekerWorkplaceTitleService = jobSeekerWorkplaceTitleService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerWorkplaceTitle>> getAll() {
		return this.jobSeekerWorkplaceTitleService.getAll();
	}
	
	@GetMapping("/getByJobSeeker_id")
	public DataResult<List<JobSeekerWorkplaceTitle>> getByJobSeeker_id(@RequestParam int jobSeekerId) {
		return this.jobSeekerWorkplaceTitleService.getByJobSeeker_id(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerWorkplaceTitle jobSeekerWorkplaceTitle) {
		return this.jobSeekerWorkplaceTitleService.add(jobSeekerWorkplaceTitle);
	}
	
}
