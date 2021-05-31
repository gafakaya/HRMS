package com.kaya.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.AuthService;
import com.kaya.hrms.business.abstracts.CompanyService;
import com.kaya.hrms.business.abstracts.JobSeekerService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.entities.Dtos.CompanyRegisterDto;
import com.kaya.hrms.entities.Dtos.JobSeekerRegisterDto;
import com.kaya.hrms.entities.concretes.Company;
import com.kaya.hrms.entities.concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

	private JobSeekerService JobSeekerService;
	private CompanyService companyService;
	
	@Autowired
	public AuthManager(
			JobSeekerService jobSeekerService,
			CompanyService companyService) {
		JobSeekerService = jobSeekerService;
		this.companyService = companyService;
	}

	@Override
	public Result jobSeekerRegister(JobSeekerRegisterDto jobSeekerDto) {
		
		if (jobSeekerDto.getFirstName().equals(null) &&
			jobSeekerDto.getLastName().equals(null) &&
			jobSeekerDto.getEmail().equals(null) &&
			jobSeekerDto.getNationalityId().equals(null) &&
			jobSeekerDto.getPassword().equals(null) &&
			jobSeekerDto.getPasswordConfirm().equals(null)
				) {
			return new SuccessResult(Messages.ERROR_ALL_INFO_ENTERED);
		}
		
		if (!jobSeekerDto.getPassword().equals(jobSeekerDto.getPasswordConfirm())) {
			return new ErrorResult(Messages.ERROR_PASSWORD_CONFIRM);
		}
		Result result = this.JobSeekerService.add(new JobSeeker(
				0,
				jobSeekerDto.getEmail(),
				jobSeekerDto.getPassword(),
				LocalDate.now(),
				jobSeekerDto.getFirstName(),
				jobSeekerDto.getLastName(),
				jobSeekerDto.getNationalityId(),
				jobSeekerDto.getDayOfBirth(),
				false
		));
		return new SuccessResult(result.getMessage());
	}

	@Override
	public Result companyRegister(CompanyRegisterDto companyDto) {
//		
//		if (companyDto.getCompanyName().equals(null) &&
//				companyDto.getWebSite().equals(null) &&
//				companyDto.getEmail().equals(null) &&
//				companyDto.getPhone().equals(null) &&
//				companyDto.getPassword().equals(null) &&
//				companyDto.getPasswordConfirm().equals(null)
//					) {
//				return new ErrorResult(Messages.ERROR_ALL_INFO_ENTERED);
//			}
		if (!companyDto.getPassword().equals(companyDto.getPasswordConfirm())) {
			return new ErrorResult(Messages.ERROR_PASSWORD_CONFIRM);
		}
		
		Result result = this.companyService.add(new Company(
				0,
				companyDto.getEmail(),
				companyDto.getPassword(),
				LocalDate.now(),
				companyDto.getCompanyName(),
				companyDto.getWebSite(),
				companyDto.getPhone(),
				false				
		));
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		return new SuccessResult(result.getMessage());
	}

}
