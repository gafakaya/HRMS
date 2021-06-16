package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobAdvertisementService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.JobAdvertisementAddDto;
import com.kaya.hrms.entities.Dtos.JobAdvertisementWithCompanyDto;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(
			JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByEnable")
	public DataResult<List<JobAdvertisement>> getByEnable() {
		return this.jobAdvertisementService.getByEnable();
	}
	
	@GetMapping("/getByEnablePage")
	public DataResult<List<JobAdvertisement>> getByEnable(int pageNo, int pageSize) {
		return this.jobAdvertisementService.getByEnable(pageNo - 1, pageSize);
	}
	
	@GetMapping("/getByEnableSortedAsc")
	public DataResult<List<JobAdvertisement>> getByEnableSortedAsc() {
		
		return this.jobAdvertisementService.getByEnableSortedAsc();
	}
	
	@GetMapping("/getByEnableSortedDesc")
	public DataResult<List<JobAdvertisement>> getByEnableSortedDesc() {
		
		return this.jobAdvertisementService.getByEnableSortedDesc();
	}
	
	@GetMapping("/getJobAdvertisementWithCompany")
	public DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementWithCompany() {
		
		return this.jobAdvertisementService.getJobAdvertisementWithCompany();
	}
	
	@GetMapping("/getJobAdvertisementWithCompanyOrderByCreatedAt")
	public DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementWithCompanyOrderByCreatedAt() {
		return this.jobAdvertisementService.getJobAdvertisementWithCompanyOrderByCreatedAt();
	}
	
	@GetMapping("/getByEnableAndCompany_companyName")
	public DataResult<List<JobAdvertisement>> getByEnableAndCompany_companyName(
			@RequestParam("companyName") String companyName) {
		return this.jobAdvertisementService.getByEnableTrueAndCompanyName(companyName);
	}
	
	@PostMapping("/add")
	public Result add(
			@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
	}
	
	@PutMapping("/update")
	public Result update(
			@RequestParam("jobAdvertisemenetId") int jobAdvertisemenetId,
			@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisemenetId, jobAdvertisement);
	}
	
}
