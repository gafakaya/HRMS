package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.CvDetail;

public interface CvDetailDao extends JpaRepository<CvDetail, Integer> {
	
	CvDetail getByJobSeeker_id(int jobSeeker);

}
