package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.LinkTypeService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.LinkType;

@RestController
@RequestMapping("/api/linkTypesController")
public class LinkTypesController {

	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypesController(LinkTypeService linkTypeService) {
		this.linkTypeService = linkTypeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<LinkType>> getAll() {
		return this.linkTypeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LinkType linkType) {
		return this.linkTypeService.add(linkType);
	}
	
}
