package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobSeekerSchoolDepartment;

public interface JobSeekerSchoolDepartmentDao extends JpaRepository<JobSeekerSchoolDepartment, Integer> {
	
	List<JobSeekerSchoolDepartment> getByJobSeeker_idOrderByDateOfGraduationDesc(
			int jobSeekerId);

	
}
