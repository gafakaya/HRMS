package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.JobSeekerSchoolDepartmentService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.JobSeekerSchoolDepartmentDao;
import com.kaya.hrms.entities.concretes.JobSeekerSchoolDepartment;

@Service
public class JobSeekerSchoolDepartmentManager implements JobSeekerSchoolDepartmentService {

	private JobSeekerSchoolDepartmentDao jobSeekerSchoolDepartmentDao;
	
	@Autowired
	public JobSeekerSchoolDepartmentManager(JobSeekerSchoolDepartmentDao jobSeekerSchoolDepartmentDao) {
		this.jobSeekerSchoolDepartmentDao = jobSeekerSchoolDepartmentDao;
	}

	@Override
	public DataResult<List<JobSeekerSchoolDepartment>> getAll() {
		List<JobSeekerSchoolDepartment> result = this.jobSeekerSchoolDepartmentDao.findAll();
		return new SuccessDataResult<List<JobSeekerSchoolDepartment>>(result);
	}

	@Override
	public Result add(JobSeekerSchoolDepartment jobSeekerSchoolDepartment) {
		this.jobSeekerSchoolDepartmentDao.save(jobSeekerSchoolDepartment);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobSeekerSchoolDepartment>> getByJobSeeker_jobSeekerIdOrderByDateOfGraduation(
			int jobSeekerId) {
		List<JobSeekerSchoolDepartment> result = this.jobSeekerSchoolDepartmentDao
				.getByJobSeeker_idOrderByDateOfGraduationDesc(jobSeekerId);
		return new SuccessDataResult<List<JobSeekerSchoolDepartment>>(result);
	}

}
