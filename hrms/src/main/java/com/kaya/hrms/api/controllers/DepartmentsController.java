package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.DepartmentService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Department;

@RestController
@RequestMapping("/api/departmentsController")
@CrossOrigin
public class DepartmentsController {
	
	private DepartmentService departmentService;

	@Autowired
	public DepartmentsController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Department>> getAll() {
		return this.departmentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Department department) {
		return this.departmentService.add(department);
	}

}
