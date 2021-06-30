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

import com.kaya.hrms.business.abstracts.JobSeekerLanguageService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobSeekerLanguagesController")
@CrossOrigin
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
	
	@GetMapping("/getByJobSeeker_id")
	public DataResult<List<JobSeekerLanguage>> getByJobSeeker_id(@RequestParam int jobSeekerId) {
		return this.jobSeekerLanguageService.getByJobSeeker_id(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
		return this.jobSeekerLanguageService.add(jobSeekerLanguage);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int jobSeekerLanguageId) {
		return this.jobSeekerLanguageService.delete(jobSeekerLanguageId);
	}
	
}
