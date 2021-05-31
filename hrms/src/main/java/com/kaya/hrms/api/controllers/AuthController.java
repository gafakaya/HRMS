package com.kaya.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.concretes.AuthManager;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.CompanyRegisterDto;
import com.kaya.hrms.entities.concretes.JobSeekerRegisterDto;

@RestController
@RequestMapping("/api/")
public class AuthController {
	
	private AuthManager authManager;

	public AuthController(AuthManager authManager) {
		this.authManager = authManager;
	}
	
	@PostMapping("jobseekers/register")
	public Result jobSeekerRegister(
			@RequestBody JobSeekerRegisterDto jobSeekerDto) {
		return this.authManager.jobSeekerRegister(jobSeekerDto);
	}
	
	
	@PostMapping("companies/register")
	public Result companyRegister(
			@RequestBody CompanyRegisterDto companyDto) {
		return this.authManager.companyRegister(companyDto);
	}
	
	

}
