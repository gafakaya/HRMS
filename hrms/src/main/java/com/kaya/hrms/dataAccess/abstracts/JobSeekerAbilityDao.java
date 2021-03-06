package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobSeekerAbility;

public interface JobSeekerAbilityDao extends JpaRepository<JobSeekerAbility, Integer> {
	
	List<JobSeekerAbility> getByJobSeeker_id(int jobSeekerId);

}
