package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobSeekerLanguageService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("api/jobSeekerLanguagesController")
public class JobSeekerLanguagesController {

	private JobSeekerLanguageService jobSeekerLanguageService;

	@Autowired
	public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
		this.jobSeekerLanguageService = jobSeekerLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerLanguage>> getAll() {
		return this.jobSeekerLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
		return this.jobSeekerLanguageService.add(jobSeekerLanguage);
	}
	
}
