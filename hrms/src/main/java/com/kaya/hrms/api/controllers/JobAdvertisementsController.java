package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class JobAdvertisementsController {
	
	private JobAdvertisementManager jobAdvertisementManager;

	@Autowired
	public JobAdvertisementsController(
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
	
	@GetMapping("/getByEnablePage")
	public DataResult<List<JobAdvertisement>> getByEnable(int pageNo, int pageSize) {
		return this.jobAdvertisementManager.getByEnable(pageNo - 1, pageSize);
	}
	
	@GetMapping("/getByEnableSortedAsc")
	public DataResult<List<JobAdvertisement>> getByEnableSortedAsc() {
		
		return this.jobAdvertisementManager.getByEnableSortedAsc();
	}
	
	@GetMapping("/getByEnableSortedDesc")
	public DataResult<List<JobAdvertisement>> getByEnableSortedDesc() {
		
		return this.jobAdvertisementManager.getByEnableSortedDesc();
	}

	@GetMapping("/getByEnableAndCompany_companyName")
	public DataResult<List<JobAdvertisement>> getByEnableAndCompany_companyName(
			@RequestParam("companyName") String companyName) {
		return this.jobAdvertisementManager.getByEnableTrueAndCompanyName(companyName);
	}
	
	@PostMapping("/add")
	public Result add(
			@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementManager.add(jobAdvertisement);
	}
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("jobAdvertisemenetId") int jobAdvertisemenetId,
			@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementManager.update(jobAdvertisemenetId, jobAdvertisement);
	}
	
}
