package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.concretes.JobAdvertisementManager;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("api/jobAdvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementManager jobAdvertisementManager;

	@Autowired
	public JobAdvertisementController(
			JobAdvertisementManager jobAdvertisementManager) {
		this.jobAdvertisementManager = jobAdvertisementManager;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementManager.getAll();
	}
	
	@GetMapping("/getByEnable")
	public DataResult<List<JobAdvertisement>> getByEnable() {
		return this.jobAdvertisementManager.getByEnable();
	}
	
	@GetMapping("/getByEnableSorted")
	public DataResult<List<JobAdvertisement>> getByEnableSorted() {
		return this.jobAdvertisementManager.getByEnableSorted();
	}

//	TODO: Fix it
	@GetMapping("/getByEnableAndCompany_companyName")
	public DataResult<List<JobAdvertisement>> getByEnableAndCompany_companyName(
			@RequestParam("companyName") String companyName) {
		return this.getByEnableAndCompany_companyName(companyName);
	}
	
	@PostMapping("/add")
	public Result add(
			@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementManager.add(jobAdvertisement);
	}
	
}
