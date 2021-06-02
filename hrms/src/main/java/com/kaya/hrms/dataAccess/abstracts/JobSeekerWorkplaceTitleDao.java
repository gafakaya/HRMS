package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobSeekerWorkplaceTitle;

public interface JobSeekerWorkplaceTitleDao extends JpaRepository<JobSeekerWorkplaceTitle, Integer> {

}
