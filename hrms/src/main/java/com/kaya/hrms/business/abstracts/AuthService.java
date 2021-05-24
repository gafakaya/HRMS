package com.kaya.hrms.business.abstracts;

import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.CompanyRegisterDto;
import com.kaya.hrms.entities.concretes.JobSeekerRegisterDto;

public interface AuthService {

	Result jobSeekerRegister(JobSeekerRegisterDto jobSeekerDto);
	
	Result companyRegister(CompanyRegisterDto companyDto);
	
	
}
