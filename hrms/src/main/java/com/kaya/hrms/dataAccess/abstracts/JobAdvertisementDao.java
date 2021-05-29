package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> findByEnable(boolean enable);
	
	List<JobAdvertisement> findByEnable(Sort sort, boolean enable);

	List<JobAdvertisement> findByEnableAndCompany_companyName(boolean enable, String companyName);
	
	
}
