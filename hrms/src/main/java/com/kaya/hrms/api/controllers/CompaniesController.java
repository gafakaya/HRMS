package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.CompanyService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.entities.concretes.Company;

@RestController
@RequestMapping("/api/companiesController/")
@CrossOrigin
public class CompaniesController {

	private CompanyService companyService ;
	
	@Autowired
	public CompaniesController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping("getAll")
	public DataResult<List<Company>> getAll() {
		return this.companyService.getAll();
	}
	
}
