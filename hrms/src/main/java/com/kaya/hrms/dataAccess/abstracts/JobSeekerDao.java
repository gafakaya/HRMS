package com.kaya.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaya.hrms.entities.concretes.JobSeeker;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	
	Optional<JobSeeker> findByEmail(String email);
	Optional<JobSeeker> findByNationalityId(String nationalityId);

}
