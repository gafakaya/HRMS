package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.WorkTimeService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.WorkTime;

@RestController
@RequestMapping("api/workTimeController/")
@CrossOrigin
public class WorkTimeController {

	private WorkTimeService workTimeService;

	@Autowired
	public WorkTimeController(WorkTimeService workTimeService) {
		this.workTimeService = workTimeService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<WorkTime>> getAll() {
		return this.workTimeService.getAll();
	}
	
	@GetMapping("getById")
	public DataResult<WorkTime> getById(@RequestParam int workTimeId) {
		return this.workTimeService.getById(workTimeId);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody WorkTime workTime) {
		return this.workTimeService.add(workTime);
	}
	
}
