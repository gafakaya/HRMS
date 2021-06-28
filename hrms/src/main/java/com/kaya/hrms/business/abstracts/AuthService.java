package com.kaya.hrms.business.abstracts;

import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.CompanyDtos.CompanyRegisterDto;
import com.kaya.hrms.entities.Dtos.JobSeekerDtos.JobSeekerRegisterDto;

public interface AuthService {

	Result jobSeekerRegister(JobSeekerRegisterDto jobSeekerDto);
	
	Result companyRegister(CompanyRegisterDto companyDto);
	
	
}
