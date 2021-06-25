package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Company;

public interface CompanyService {
	
	DataResult<List<Company>> getAll();
	
	DataResult<Company> getById(int companyId);
	
	Result add(Company company);
	
	Result delete(int companyId);
	
	Result confirmation(int companyId, boolean confirm);
	
//	Result update(JobSeeker jobSeeker);
}
