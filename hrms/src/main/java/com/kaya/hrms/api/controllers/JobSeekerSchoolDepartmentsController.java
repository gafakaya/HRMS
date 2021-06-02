package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.JobSeekerSchoolDepartmentService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.JobSeekerSchoolDepartment;

@RestController
@RequestMapping("/api/jobSeekerSchoolDepartmentsController")
public class JobSeekerSchoolDepartmentsController {
	
	private JobSeekerSchoolDepartmentService jobSeekerSchoolDepartmentService;

	@Autowired
	public JobSeekerSchoolDepartmentsController(JobSeekerSchoolDepartmentService jobSeekerSchoolDepartmentService) {
		this.jobSeekerSchoolDepartmentService = jobSeekerSchoolDepartmentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerSchoolDepartment>> getAll() {
		return this.jobSeekerSchoolDepartmentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerSchoolDepartment jobSeekerSchoolDepartment) {
		return this.jobSeekerSchoolDepartmentService.add(jobSeekerSchoolDepartment);
	}

	@GetMapping("/getByJobSeeker_jobSeekerIdOrderByDateOfGraduation")
	public DataResult<List<JobSeekerSchoolDepartment>> getByJobSeeker_jobSeekerIdOrderByDateOfGraduation(
			@RequestParam int jobSeekerId) {
		return this.jobSeekerSchoolDepartmentService.getByJobSeeker_jobSeekerIdOrderByDateOfGraduation(jobSeekerId);
	}

}
