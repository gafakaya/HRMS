package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobSeeker;
import com.kaya.hrms.entities.concretes.JobSeekerPhoto;

public interface JobSeekerPhotoDao extends JpaRepository<JobSeekerPhoto, Integer> {
	
	JobSeekerPhoto getByJobSeeker_id(int jobSeekerId);

}
