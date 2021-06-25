package com.kaya.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.CompanyService;
import com.kaya.hrms.business.abstracts.WorkplaceService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.business.validationRules.EmailValidator;
import com.kaya.hrms.core.utilities.business.BusinessRules;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.ErrorDataResult;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.CompanyDao;
import com.kaya.hrms.entities.concretes.Company;
import com.kaya.hrms.entities.concretes.JobAdvertisement;
import com.kaya.hrms.entities.concretes.Workplace;

@Service
public class CompanyManager implements CompanyService {

	private CompanyDao companyDao;
	private VerificationManager verificationManager;
	private WorkplaceService workplaceService;

	@Autowired
	public CompanyManager(
			CompanyDao companyDao,
			VerificationManager verificationManager,
			WorkplaceService workplaceService) {
		this.companyDao = companyDao;
		this.verificationManager = verificationManager;
		this.workplaceService = workplaceService;
	}


	@Override
	public DataResult<List<Company>> getAll() {
		List<Company> result = this.companyDao.findAll();
		return new SuccessDataResult<List<Company>>(result, Messages.COMPANIES_LISTED);
	}

	@Override
	public DataResult<Company> getById(int companyId) {
		Optional<Company> result = this.companyDao.findById(companyId);
		if (!result.isPresent()) {
			return new ErrorDataResult<Company>("Company is not found.");
		}
		return new SuccessDataResult<Company>(result.get());
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
		
//		Result isConfirm = checkEmployeesConfirmation(company);
//		if(!isConfirm.isSuccess()) {
//			return isConfirm;
//		}
		
		company.setActive(true);
		Workplace workplace = new Workplace();
		workplace.setWorkplaceName(companyName);
		this.workplaceService.add(workplace);
		companyDao.save(company);
		
		return new SuccessResult(Messages.COMPANY_ADDED);
	}

	@Override
	public Result delete(int companyId) {
		Company result = this.companyDao.getById(companyId);
		this.companyDao.delete(result);
		return new SuccessResult(Messages.COMPANY_DELETED);
	}
	
	@Override
	public Result confirmation(int companyId, boolean confirm) {
		Company result = this.companyDao.getById(companyId);
		
		if (!confirm){
			result.setConfirm(false);
			this.companyDao.save(result);
			return new SuccessResult(Messages.COMPANY_CONFIRMATION_IS_DELAYED);
		}
		
		result.setConfirm(true);
		
		this.companyDao.save(result);

		return new SuccessResult(Messages.COMPANY_CONFIRMATION_IS_ACCEPTED);
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
