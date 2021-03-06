package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobSeekerService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.CvDto;
import com.kaya.hrms.entities.Dtos.JobSeekerDtos.JobSeekerUpdateDto;
import com.kaya.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobSeekersController")
@CrossOrigin
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}

	@GetMapping("/getJobSeekerResumeByJobSeekerId")
	public DataResult<CvDto> getJobSeekerResumeByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.jobSeekerService.getJobSeekerResumeByJobSeekerId(jobSeekerId);
	}
	
	@GetMapping("/getById")
	public DataResult<JobSeeker> getById(@RequestParam int jobSeekerId) {
		return this.jobSeekerService.getById(jobSeekerId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestParam int jobSeekerId,@RequestBody JobSeekerUpdateDto jobSeekerUpdateDto) {
		return this.jobSeekerService.update(jobSeekerId, jobSeekerUpdateDto);
	}

}
