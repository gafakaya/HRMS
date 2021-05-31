package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaya.hrms.entities.Dtos.JobAdvertisementWithCompanyDto;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByEnableTrue();
	
	Page<JobAdvertisement> getByEnableTrue(Pageable pageable);

	List<JobAdvertisement> getByEnableTrueOrderByApplicaitonDatelineAsc();
	
	List<JobAdvertisement> getByEnableTrueOrderByApplicaitonDatelineDesc();

	List<JobAdvertisement> getByEnableTrueAndCompany_companyName(String companyName);
	
	@Query("Select new com.kaya.hrms.entities.Dtos."
			+ "JobAdvertisementWithCompanyDto(c.companyName, t.title, cty.cityName, j.numberOfOpenPositions, j.createdAt, j.applicaitonDateline) "
			+ "from JobAdvertisement j "
			+ "Inner join j.jobTitle t "
			+ "Inner join j.company c "
			+ "Inner join j.city cty")
	List<JobAdvertisementWithCompanyDto> getJobAdvertisementWithCompany();
	
//	FROM job_positions,sector_positions,company WHERE job_positions.sector_position_id=sector_positions.id and job_positions.company_id=company.id group by job_positions.id,company.company_name,job_positions.person_count,job_positions.job_application_end_time,job_positions.job_application_start_time,sector_positions.position_name
	
}
