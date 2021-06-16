package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.WorkTypeService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("api/workTypeController/")
@CrossOrigin
public class WorkTypeController {
	
	private WorkTypeService workTypeService;

	@Autowired
	public WorkTypeController(WorkTypeService workTypeService) {
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<WorkType>> getAll() {
		return this.workTypeService.getAll();
	}
	
	@GetMapping("getById")
	public DataResult<WorkType> getById(int workTypeId) {
		return this.workTypeService.getById(workTypeId);
	}
	
	@PostMapping("add")
	public Result add(WorkType workType) {
		return this.workTypeService.add(workType);
	}

}
