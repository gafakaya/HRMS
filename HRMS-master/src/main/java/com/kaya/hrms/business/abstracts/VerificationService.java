package com.kaya.hrms.business.abstracts;

import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Company;

public interface VerificationService {
	
	Result verificateMail(String email);
	
	Result companyVerificationByEmployee(Company company);

}
