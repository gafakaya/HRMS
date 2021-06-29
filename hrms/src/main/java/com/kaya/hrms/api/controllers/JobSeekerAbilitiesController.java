package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobSeekerAbilityService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerAbility;

@RestController
@RequestMapping("/api/jobSeekerAbilitiesController")
@CrossOrigin
public class JobSeekerAbilitiesController {

	private JobSeekerAbilityService jobSeekerAbilityService;

	@Autowired
	public JobSeekerAbilitiesController(JobSeekerAbilityService jobSeekerAbilityService) {
		this.jobSeekerAbilityService = jobSeekerAbilityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerAbility>> getAll() {
		return this.jobSeekerAbilityService.getAll();
	}
	
	@GetMapping("/getByJobSeeker_id")
	public DataResult<List<JobSeekerAbility>> getByJobSeeker_id(@RequestParam int jobSeekerId) {
		return this.jobSeekerAbilityService.getByJobSeeker_id(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerAbility jobSeekerAbility) {
		return this.jobSeekerAbilityService.add(jobSeekerAbility);
	}
	
	@DeleteMapping("/delete")
	public Result delete(int jobSeekerAbilityId) {
		return this.jobSeekerAbilityService.delete(jobSeekerAbilityId);
	}
	
}
