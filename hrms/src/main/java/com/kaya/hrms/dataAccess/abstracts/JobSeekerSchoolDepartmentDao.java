package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobSeekerSchoolDepartment;

public interface JobSeekerSchoolDepartmentDao extends JpaRepository<JobSeekerSchoolDepartment, Integer> {

}
