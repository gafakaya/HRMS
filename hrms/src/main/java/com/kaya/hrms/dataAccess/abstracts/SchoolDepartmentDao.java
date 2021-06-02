package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer> {

}
