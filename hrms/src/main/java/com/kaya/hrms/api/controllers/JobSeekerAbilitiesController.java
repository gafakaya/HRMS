package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobSeekerAbilityService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerAbility;

@RestController
@RequestMapping("/api/jobSeekerAbilitiesController")
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
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerAbility jobSeekerAbility) {
		return this.jobSeekerAbilityService.add(jobSeekerAbility);
	}
	
}
