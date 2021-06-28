package com.kaya.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.CityService;
import com.kaya.hrms.business.abstracts.CompanyService;
import com.kaya.hrms.business.abstracts.JobAdvertisementService;
import com.kaya.hrms.business.abstracts.JobTitleService;
import com.kaya.hrms.business.abstracts.WorkTimeService;
import com.kaya.hrms.business.abstracts.WorkTypeService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kaya.hrms.entities.Dtos.JobAdvertisementDtos.JobAdvertisementAddDto;
import com.kaya.hrms.entities.Dtos.JobAdvertisementDtos.JobAdvertisementUpdateDto;
import com.kaya.hrms.entities.Dtos.JobAdvertisementDtos.JobAdvertisementWithCompanyDto;
import com.kaya.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private CityService cityService;
	private WorkTypeService workTypeService;
	private WorkTimeService workTimeService;
	private JobTitleService jobTitleService;
	private CompanyService companyService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityService cityService,
			WorkTypeService workTypeService, WorkTimeService workTimeService, JobTitleService jobTitleService,
			CompanyService companyService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityService = cityService;
		this.workTypeService = workTypeService;
		this.workTimeService = workTimeService;
		this.jobTitleService = jobTitleService;
		this.companyService = companyService;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		List<JobAdvertisement> result = this.jobAdvertisementDao.findAll();
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEnable() {
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrue();
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_LISTED_BY_ENABLE);
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByEnable(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrue(pageable).getContent();
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_PAGED_BY_ENABLE);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEnableSortedAsc() {
		
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrueOrderByApplicationDeadlineAsc();
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_SORTED_BY_ENABLE);
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByEnableSortedDesc() {
		
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrueOrderByApplicationDeadlineDesc();
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_SORTED_BY_ENABLE);
	}

	@Override
	public DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementWithCompany() {
		List<JobAdvertisementWithCompanyDto> result = this.jobAdvertisementDao.getJobAdvertisementWithCompany();
		return new SuccessDataResult<List<JobAdvertisementWithCompanyDto>>(
				result, 
				Messages.JOB_ADVERTISEMENT_DTO_LISTED);
	}

	@Override
	public DataResult<JobAdvertisementWithCompanyDto> getJobAdvertisementWithCompanyById(int jobAdvertisementId) {
		JobAdvertisementWithCompanyDto result = this.jobAdvertisementDao.getJobAdvertisementWithCompanyById(jobAdvertisementId);
		return new SuccessDataResult<JobAdvertisementWithCompanyDto>(result);
	}

	@Override
	public DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementsNonConfirm() {
		List<JobAdvertisementWithCompanyDto> result = this.jobAdvertisementDao.getJobAdvertisementsNonConfirm();
		return new SuccessDataResult<List<JobAdvertisementWithCompanyDto>>(
				result,
				Messages.JOB_ADVERTISEMENT_NONCONFIRM_LISTED);
	}
	
	@Override
	public DataResult<List<JobAdvertisementWithCompanyDto>> getJobAdvertisementWithCompanyOrderByCreatedAt() {
		List<JobAdvertisementWithCompanyDto> result = this.jobAdvertisementDao.getJobAdvertisementWithCompanyOrderByCreatedAt();
		return new SuccessDataResult<List<JobAdvertisementWithCompanyDto>>(
				result, 
				Messages.JOB_ADVERTISEMENT_DTO_LISTED);
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByEnableTrueAndCompanyName(String companyName) {
		List<JobAdvertisement> result = this.jobAdvertisementDao
				.getByEnableTrueAndCompany_companyName(companyName);
		return new SuccessDataResult<List<JobAdvertisement>>(
				result,
				Messages.JOB_ADVERTISEMENT_LISTED_BY_COMPANYID_ENABLE);
	}

	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setLike(0);
		jobAdvertisement.setCreatedAt(LocalDateTime.now());
		jobAdvertisement.setConfirm(false);
		jobAdvertisement.setApplicationDeadline(jobAdvertisementAddDto.getApplicationDeadline());
		jobAdvertisement.setJobDescription(jobAdvertisementAddDto.getJobDescription());
		jobAdvertisement.setMaxSalary(jobAdvertisementAddDto.getMaxSalary());
		jobAdvertisement.setMinSalary(jobAdvertisementAddDto.getMinSalary());
		jobAdvertisement.setNumberOfOpenPositions(jobAdvertisementAddDto.getNumberOfOpenPositions());
		jobAdvertisement.setCompany(this.companyService.getById(jobAdvertisementAddDto.getCompanyId()).getData());
		jobAdvertisement.setWorkTime(this.workTimeService.getById(jobAdvertisementAddDto.getWorkTimeId()).getData());
		jobAdvertisement.setWorkType(this.workTypeService.getById(jobAdvertisementAddDto.getWorkTypeId()).getData());
		jobAdvertisement.setJobTitle(this.jobTitleService.getById(jobAdvertisementAddDto.getJobTitleId()).getData());
		jobAdvertisement.setCity(this.cityService.getById(jobAdvertisementAddDto.getCityId()).getData());
		
		
		if(jobAdvertisement.getApplicationDeadline().isBefore(LocalDate.now())) {
			jobAdvertisement.setEnable(false);
		}
		jobAdvertisement.setEnable(true);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult();
	}

	@Override
	public Result update(int jobAdvertisementId, JobAdvertisementUpdateDto jobAdvertisementUpdateDto) {
		
		JobAdvertisement result = this.jobAdvertisementDao.getById(jobAdvertisementId);
		result.setConfirm(jobAdvertisementUpdateDto.isConfirm()); // TODO : Confirm false ise iş ilani silinsin.
		result.setApplicationDeadline(jobAdvertisementUpdateDto.getApplicationDeadline());
		result.setJobDescription(jobAdvertisementUpdateDto.getJobDescription());
		result.setMaxSalary(jobAdvertisementUpdateDto.getMaxSalary());
		result.setMinSalary(jobAdvertisementUpdateDto.getMinSalary());
		result.setNumberOfOpenPositions(jobAdvertisementUpdateDto.getNumberOfOpenPositions());
		result.setWorkTime(this.workTimeService.getById(jobAdvertisementUpdateDto.getWorkTimeId()).getData());
		result.setWorkType(this.workTypeService.getById(jobAdvertisementUpdateDto.getWorkTypeId()).getData());
		result.setJobTitle(this.jobTitleService.getById(jobAdvertisementUpdateDto.getJobTitleId()).getData());
		result.setCity(this.cityService.getById(jobAdvertisementUpdateDto.getCityId()).getData());
		
		if(jobAdvertisementUpdateDto.getApplicationDeadline().isBefore(LocalDate.now())) {
			result.setEnable(false);
		}
		
		result.setEnable(jobAdvertisementUpdateDto.isEnable());
		
		this.jobAdvertisementDao.save(result);
		return  new SuccessResult();
	}

	@Override
	public Result delete(int jobAdvertisementId) {
		JobAdvertisement result = this.jobAdvertisementDao.getById(jobAdvertisementId);
		this.jobAdvertisementDao.delete(result);
		return new SuccessResult(Messages.JOB_ADVERTISEMENT_DELETED);
	}
	
	@Override
	public Result confirmation(int jobAdvertisementId, boolean confirm) {

		JobAdvertisement result = this.jobAdvertisementDao.getById(jobAdvertisementId);
		
		if (!confirm){
			this.delete(jobAdvertisementId);
			return new SuccessResult(Messages.JOB_ADVERTISEMENT_DELETED);
		}
		
		result.setConfirm(true);
		
		this.jobAdvertisementDao.save(result);

		return new SuccessResult(Messages.JOB_ADVERTISEMENT_CONFIRMED);
	}
	

}
