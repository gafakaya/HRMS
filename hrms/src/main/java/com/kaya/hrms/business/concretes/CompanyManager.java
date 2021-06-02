package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.CompanyService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.business.validationRules.EmailValidator;
import com.kaya.hrms.core.utilities.business.BusinessRules;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.CompanyDao;
import com.kaya.hrms.entities.concretes.Company;

@Service
public class CompanyManager implements CompanyService {

	private CompanyDao companyDao;
	private VerificationManager verificationManager;
	

	@Autowired
	public CompanyManager(
			CompanyDao companyDao,
			VerificationManager verificationManager) {
		this.companyDao = companyDao;
		this.verificationManager = verificationManager;
	}

	@Override
	public DataResult<List<Company>> getAll() {
		List<Company> result = this.companyDao.findAll();
		return new SuccessDataResult<List<Company>>(result, Messages.COMPANIES_LISTED);
	}

	@Override
	public DataResult<Company> getById(int companyId) {
		return null;
	}

	@Override
	public Result add(Company company) {
			
		String email = company.getEmail();
		String companyName = company.getCompanyName();
		
		Result rules = BusinessRules.Run(
				checkCompanyExists(email)
		);
		if(rules != null) {
			return rules;
		}
		
		Result isEmailVerificate = checkEmailVerification(company);		
		if(!isEmailVerificate.isSuccess()) {
			return isEmailVerificate;
		}
		
		Result isConfirm = checkEmployeesConfirmation(company);
		if(!isConfirm.isSuccess()) {
			return isConfirm;
		}
		
		company.setActive(true);
		companyDao.save(company);
		
		return new SuccessResult(Messages.COMPANY_ADDED);
	}

	@Override
	public Result delete(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Result checkEmployeesConfirmation(Company company) {
		Result companyVerificationResult = this.verificationManager
				.companyVerificationByEmployee(company);
		if (!companyVerificationResult.isSuccess()) {
			return new ErrorResult(companyVerificationResult.getMessage());
		}
		
		return new SuccessResult();
	}
	
	public Result checkCompanyExists(String email) {
		boolean companyExists = this.companyDao
				.findByEmail(email)
				.isPresent();
		if (companyExists) {
			return new ErrorResult(Messages.ERROR_COMPANY_EXISTS);
		}
		
		return new SuccessResult();
	}
	
	public Result checkEmailVerification(Company company) {
		
		String email = company.getEmail();
		
		Result verificationMailResult = this.verificationManager
				.verificateMail(email);
		
		if (!verificationMailResult.isSuccess()) {
			return verificationMailResult;
		}
		
		return verificationMailResult;
	}

}
