package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaya.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByEnableTrue();
	
	Page<JobAdvertisement> getByEnableTrue(Pageable pageable);

	List<JobAdvertisement> getByEnableTrueOrderByApplicaitonDatelineAsc();
	
	List<JobAdvertisement> getByEnableTrueOrderByApplicaitonDatelineDesc();

	List<JobAdvertisement> getByEnableTrueAndCompany_companyName(String companyName);
	
}
