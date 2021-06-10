package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobAdvertisementApplicationService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobAdvertisementApplication;

@RestController
@RequestMapping("/api/jobAdvertisementApplicationsController")
public class JobAdvertisementApplicationsController {

	private JobAdvertisementApplicationService jobAdvertisementApplicationService;

	@Autowired
	public JobAdvertisementApplicationsController(
			JobAdvertisementApplicationService jobAdvertisementApplicationService) {
		this.jobAdvertisementApplicationService = jobAdvertisementApplicationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementApplication>> getAll() {
		return this.jobAdvertisementApplicationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementApplication jobAdvertisementApplication) {
		return this.jobAdvertisementApplicationService.add(jobAdvertisementApplication);
	}
	
}
