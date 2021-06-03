package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.SocialMediaService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialMediasController")
public class SocialMediasController {

	private SocialMediaService socialMediaService;
	
	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll() {
		return this.socialMediaService.getAll();
	}
	
	@GetMapping("/getByJobSeeker_id")
	public DataResult<List<SocialMedia>> getByJobSeeker_id(@RequestParam int jobSeekerId) {
		return this.socialMediaService.getByJobSeeker_id(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.add(socialMedia);
	}
	
	
}
