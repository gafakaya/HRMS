package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
	
	List<SocialMedia> getByJobSeeker_id(int jobSeekerId);

}
