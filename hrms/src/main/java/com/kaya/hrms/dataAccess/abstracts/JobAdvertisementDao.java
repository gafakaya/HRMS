package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaya.hrms.entities.Dtos.JobAdvertisementDtos.JobAdvertisementWithCompanyDto;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByEnableTrue();
	
	Page<JobAdvertisement> getByEnableTrue(Pageable pageable);

	List<JobAdvertisement> getByEnableTrueOrderByApplicationDeadlineAsc();
	
	List<JobAdvertisement> getByEnableTrueOrderByApplicationDeadlineDesc();

	List<JobAdvertisement> getByEnableTrueAndCompany_companyName(String companyName);


	@Query("Select new com.kaya.hrms.entities.Dtos.JobAdvertisementDtos."
			+ "JobAdvertisementWithCompanyDto(j.id, c.companyName, t.title, cty.cityName"
			+ ", j.jobDescription, j.like, j.numberOfOpenPositions, j.createdAt"
			+ ", j.applicationDeadline, wtime.workTimeName, wtype.workTypeName"
			+ ", j.maxSalary, j.minSalary) "
			+ "from JobAdvertisement j "
			+ "Inner join j.jobTitle t "
			+ "Inner join j.company c "
			+ "Inner join j.city cty "
			+ "Inner join j.workTime wtime "
			+ "Inner join j.workType wtype ")
	List<JobAdvertisementWithCompanyDto> getJobAdvertisementWithCompany();


	@Query("Select new com.kaya.hrms.entities.Dtos.JobAdvertisementDtos."
			+ "JobAdvertisementWithCompanyDto(j.id, c.companyName, t.title, cty.cityName"
			+ ", j.jobDescription, j.like, j.numberOfOpenPositions, j.createdAt"
			+ ", j.applicationDeadline, wtime.workTimeName, wtype.workTypeName"
			+ ", j.maxSalary, j.minSalary) "
			+ "from JobAdvertisement j "
			+ "Inner join j.jobTitle t "
			+ "Inner join j.company c "
			+ "Inner join j.city cty "
			+ "Inner join j.workTime wtime "
			+ "Inner join j.workType wtype "
			+ "where j.id = ?1 "
			+ "AND j.enable = true")
	JobAdvertisementWithCompanyDto getJobAdvertisementWithCompanyById(int jobAdvertisementId);
	
	@Query("Select new com.kaya.hrms.entities.Dtos.JobAdvertisementDtos."
			+ "JobAdvertisementWithCompanyDto(j.id, c.companyName, t.title, cty.cityName"
			+ ", j.jobDescription, j.like, j.numberOfOpenPositions, j.createdAt"
			+ ", j.applicationDeadline, wtime.workTimeName, wtype.workTypeName"
			+ ", j.maxSalary, j.minSalary) "
			+ "from JobAdvertisement j "
			+ "Inner join j.jobTitle t "
			+ "Inner join j.company c "
			+ "Inner join j.city cty "
			+ "Inner join j.workTime wtime "
			+ "Inner join j.workType wtype "
			+ "where j.confirm = false "
			+ "AND j.enable = true	")
	List<JobAdvertisementWithCompanyDto> getJobAdvertisementsNonConfirm();
	
	@Query("Select new com.kaya.hrms.entities.Dtos.JobAdvertisementDtos."
			+ "JobAdvertisementWithCompanyDto(j.id, c.companyName, t.title, cty.cityName"
			+ ", j.jobDescription, j.like, j.numberOfOpenPositions, j.createdAt"
			+ ", j.applicationDeadline, wtime.workTimeName, wtype.workTypeName"
			+ ", j.maxSalary, j.minSalary) "
			+ "from JobAdvertisement j "
			+ "Inner join j.jobTitle t "
			+ "Inner join j.company c "
			+ "Inner join j.city cty "
			+ "Inner join j.workTime wtime "	
			+ "Inner join j.workType wtype "
			+ "where j.confirm = true "
			+ "AND j.enable = true	"
			+ "Order By j.createdAt desc")
	List<JobAdvertisementWithCompanyDto> getJobAdvertisementWithCompanyOrderByCreatedAt();

}
