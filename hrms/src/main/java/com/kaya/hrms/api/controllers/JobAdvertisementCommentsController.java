package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobAdvertisementCommentService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobAdvertisementComment;

@RestController
@RequestMapping("/api/jobAdvertisementCommentsController")
@CrossOrigin
public class JobAdvertisementCommentsController {

	private JobAdvertisementCommentService jobAdvertisementCommentService;

	@Autowired
	public JobAdvertisementCommentsController(JobAdvertisementCommentService jobAdvertisementCommentService) {
		this.jobAdvertisementCommentService = jobAdvertisementCommentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementComment>> getAll() {
		return this.jobAdvertisementCommentService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementComment jobAdvertisementComment) {
		return this.jobAdvertisementCommentService.add(jobAdvertisementComment);
	}
	
}
