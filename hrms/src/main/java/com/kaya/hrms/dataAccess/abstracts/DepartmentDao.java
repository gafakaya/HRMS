package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
