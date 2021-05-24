package com.kaya.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobSeekerService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.business.validationRules.EmailValidator;
import com.kaya.hrms.core.adapters.MernisService;
import com.kaya.hrms.core.utilities.business.BusinessRules;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kaya.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private VerificationManager verificationManager;
	private MernisService mernisService;
	
	@Autowired
	public JobSeekerManager(
			JobSeekerDao jobSeekerDao, 
			VerificationManager verificationManager,
			MernisService mernisService) {
		this.jobSeekerDao = jobSeekerDao;
		this.verificationManager = verificationManager;
		this.mernisService = mernisService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		List<JobSeeker> result = this.jobSeekerDao.findAll();
		return new SuccessDataResult<List<JobSeeker>>(result, Messages.JOB_SEEKERS_LISTED);
	}

	@Override
	public DataResult<JobSeeker> getById(int jobSeekerId) {
		return null;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		String email = jobSeeker.getEmail();
		String firstName = jobSeeker.getFirstName();
		String lastName = jobSeeker.getLastName();
		String nationalityId = jobSeeker.getNationalityId();
		LocalDate dayOfBirth = jobSeeker.getDayOfBirth();		
		
		Result rules = BusinessRules.Run(
				checkUserExists(email, nationalityId),
				EmailValidator.jobSeekerEmailValid(email),
				this.mernisService.checkIfRealPerson(
						firstName,
						lastName,
						nationalityId,
						dayOfBirth));
		
		if(rules != null) {
			return rules;
		}
		
		Result isEmailVerificate = checkEmailVerification(jobSeeker);		
		if(!isEmailVerificate.isSuccess()) {
			return isEmailVerificate;
		}
		
		jobSeeker.setConfirm(true);
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_ADDED);
	}

	@Override
	public Result delete(int jobSeekerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Result checkUserExists(String email, String nationalityId) {
		
//		TODO: fix the bug...
		boolean userEmailExists = this.jobSeekerDao
				.findByEmail(email)
				.isPresent();
		boolean userNationalityIdExists = this.jobSeekerDao
				.findByNationalityId(nationalityId)
				.isPresent();
		if (userEmailExists && userNationalityIdExists) {
			new ErrorResult(Messages.ERROR_JOB_SEEKER_EXISTS);
		}
		
		return new SuccessResult();
	}
	
	public Result checkEmailVerification(JobSeeker jobSeeker) {
		
		String email = jobSeeker.getEmail();
		
		Result verificationMailResult = this.verificationManager
				.verificateMail(email);
		
		if (!verificationMailResult.isSuccess()) {
			return verificationMailResult;
		}
		
		return verificationMailResult;
	}
	

}
