package com.kaya.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.CvDetailService;
import com.kaya.hrms.business.abstracts.JobSeekerAbilityService;
import com.kaya.hrms.business.abstracts.JobSeekerLanguageService;
import com.kaya.hrms.business.abstracts.JobSeekerSchoolDepartmentService;
import com.kaya.hrms.business.abstracts.JobSeekerService;
import com.kaya.hrms.business.abstracts.JobSeekerWorkplaceTitleService;
import com.kaya.hrms.business.abstracts.SocialMediaService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.adapters.MernisService;
import com.kaya.hrms.core.utilities.business.BusinessRules;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.ErrorDataResult;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kaya.hrms.entities.Dtos.CvDto;
import com.kaya.hrms.entities.Dtos.JobSeekerDtos.JobSeekerUpdateDto;
import com.kaya.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private VerificationManager verificationManager;
	private MernisService mernisService;
	private JobSeekerWorkplaceTitleService jobSeekerWorkplaceTitleService;
	private JobSeekerSchoolDepartmentService jobSeekerSchoolDepartmentService;
	private JobSeekerLanguageService jobSeekerLanguageService;
	private JobSeekerAbilityService jobSeekerAbilityService;
	private SocialMediaService socialMediaService;
	private CvDetailService cvDetailService;
	
	@Autowired
	public JobSeekerManager(
			JobSeekerDao jobSeekerDao,
			VerificationManager verificationManager,
			MernisService mernisService, 
			JobSeekerWorkplaceTitleService jobSeekerWorkplaceTitleService,
			JobSeekerSchoolDepartmentService jobSeekerSchoolDepartmentService,
			JobSeekerLanguageService jobSeekerLanguageService, 
			JobSeekerAbilityService jobSeekerAbilityService,
			SocialMediaService socialMediaService,
			CvDetailService cvDetailService) {
		this.jobSeekerDao = jobSeekerDao;
		this.verificationManager = verificationManager;
		this.mernisService = mernisService;
		this.jobSeekerWorkplaceTitleService = jobSeekerWorkplaceTitleService;
		this.jobSeekerSchoolDepartmentService = jobSeekerSchoolDepartmentService;
		this.jobSeekerLanguageService = jobSeekerLanguageService;
		this.jobSeekerAbilityService = jobSeekerAbilityService;
		this.socialMediaService = socialMediaService;
		this.cvDetailService = cvDetailService;
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
		
		return new SuccessDataResult<JobSeeker>(result, Messages.JOB_SEEKER_LISTED_BYID);
	}

	@Override
	public DataResult<CvDto> getJobSeekerResumeByJobSeekerId(int jobSeekerId) {
		
		CvDto cvDto = new CvDto();
		
		cvDto.setJobSeeker(this.jobSeekerDao.getById(jobSeekerId));
		cvDto.setJobSeekerAbilities(this.jobSeekerAbilityService.getByJobSeeker_id(jobSeekerId).getData());
		cvDto.setJobSeekerLanguages(this.jobSeekerLanguageService.getByJobSeeker_id(jobSeekerId).getData());
		cvDto.setJobSeekerSchoolDepartments(this.jobSeekerSchoolDepartmentService.getByJobSeeker_jobSeekerIdOrderByDateOfGraduationDesc(jobSeekerId).getData());
		cvDto.setJobSeekerWorkplaceTitles(this.jobSeekerWorkplaceTitleService.getByJobSeeker_id(jobSeekerId).getData());
		cvDto.setSocialMedias(this.socialMediaService.getByJobSeeker_id(jobSeekerId).getData());
		cvDto.setCvDetail(this.cvDetailService.getByJobSeeker_id(jobSeekerId).getData());
		
		return new SuccessDataResult<CvDto>(cvDto);
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
	public Result update(int jobSeekerId, JobSeekerUpdateDto jobSeekerUpdateDto) {
		
		Result rules = BusinessRules.Run(checkUserExistsById(jobSeekerId));
		
		if(rules != null) {
			return rules;
		}
		
		JobSeeker result = getById(jobSeekerId).getData();
		
		result.setFirstName(jobSeekerUpdateDto.getFirstName());
		result.setLastName(jobSeekerUpdateDto.getLastName());
		result.setEmail(jobSeekerUpdateDto.getEmail());
		result.setDayOfBirth(jobSeekerUpdateDto.getDayOfBirth());
		
		this.jobSeekerDao.save(result);
		
		return new SuccessResult(Messages.JOB_SEEKER_UPDATED);
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
	//..
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
