package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobTitleService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitleController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitleController(JobTitleService jobTitleService) {
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@GetMapping("/getbyname")
	public DataResult<JobTitle> getByName(@RequestParam String jobTitleName){
		return this.jobTitleService.getByName(jobTitleName);
	}
//	TODO: CRUD...
}
