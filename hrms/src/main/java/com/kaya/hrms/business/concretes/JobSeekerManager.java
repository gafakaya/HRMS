package com.kaya.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobSeekerService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.business.validationRules.EmailValidator;
import com.kaya.hrms.core.adapters.MernisService;
import com.kaya.hrms.core.utilities.business.BusinessRules;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.ErrorDataResult;
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

		Result rules = BusinessRules.Run(checkUserExistsById(jobSeekerId));
		
		if(rules != null) {
			return new ErrorDataResult<JobSeeker>(rules.getMessage());
		}
		
		JobSeeker result = this.jobSeekerDao.findById(jobSeekerId).get();
		
		return new SuccessDataResult<JobSeeker>(result, Messages.ERROR_JOB_SEEKER_NOT_FOUND);
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
		
		Result rules = BusinessRules.Run(checkUserExistsById(jobSeekerId));
		
		if(rules != null) {
			return rules;
		}
		
		this.jobSeekerDao.deleteById(jobSeekerId);
		
		return new SuccessResult(Messages.JOB_SEEKER_DELETED);
	}

	@Override
	public Result update(int jobSeekerId, JobSeeker jobSeeker) {
		
		Result rules = BusinessRules.Run(checkUserExistsById(jobSeekerId));
		
		if(rules != null) {
			return rules;
		}
		
		JobSeeker result = getById(jobSeekerId).getData();
		
		result.setFirstName(jobSeeker.getFirstName());
		result.setLastName(jobSeeker.getLastName());
		result.setPassword(jobSeeker.getPassword());
		
		return null;
	}
	
	
	
//	-----------------------------------------------------------------------------
	
	
	public Result checkUserExistsById(int jobSeekerId) {
		
		Optional<JobSeeker> result = this.jobSeekerDao.findById(jobSeekerId);
		
		boolean isPresent = result.isPresent();
		
		if(!isPresent) {
			return new ErrorResult(Messages.ERROR_JOB_SEEKER_NOT_FOUND);
		}
		
		return new SuccessResult();
	}
	
	@Override
	public Result checkUserExists(String email, String nationalityId) {
		
		boolean userEmailExists = this.jobSeekerDao
				.findByEmail(email)
				.isPresent();
		boolean userNationalityIdExists = this.jobSeekerDao
				.findByNationalityId(nationalityId)
				.isPresent();
		if (userEmailExists || userNationalityIdExists) {
			return new ErrorResult(Messages.ERROR_JOB_SEEKER_EXISTS);
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
