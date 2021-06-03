package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobSeekerWorkplaceTitle;

public interface JobSeekerWorkplaceTitleDao extends JpaRepository<JobSeekerWorkplaceTitle, Integer> {
	
	List<JobSeekerWorkplaceTitle> getByJobSeeker_id(int jobSeekerId);

}
