package com.kaya.hrms.business.abstracts;

import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.CompanyRegisterDto;
import com.kaya.hrms.entities.Dtos.JobSeekerRegisterDto;

public interface AuthService {

	Result jobSeekerRegister(JobSeekerRegisterDto jobSeekerDto);
	
	Result companyRegister(CompanyRegisterDto companyDto);
	
	
}
