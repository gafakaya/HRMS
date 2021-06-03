package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.CvDetailService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.CvDetail;

@RestController
@RequestMapping(name="/api/cvDetailsController")
public class CvDetailsController {

	private CvDetailService cvDetailService;

	@Autowired
	public CvDetailsController(CvDetailService cvDetailService) {
		this.cvDetailService = cvDetailService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvDetail>> getAll() {
		return this.cvDetailService.getAll();
	}
	
	@GetMapping("/getByJobSeeker_id")
	public DataResult<CvDetail> getByJobSeeker_id(@RequestParam int jobSeeker) {
		return this.cvDetailService.getByJobSeeker_id(jobSeeker);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvDetail cvDetail) {
		return this.cvDetailService.add(cvDetail);
	}
	
}
