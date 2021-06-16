package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.WorkTimeService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.WorkTimeDao;
import com.kaya.hrms.entities.concretes.WorkTime;

@Service
public class WorkTimeManager implements WorkTimeService {
	
	private WorkTimeDao workTimeDao;

	@Autowired
	public WorkTimeManager(WorkTimeDao workTimeDao) {
		this.workTimeDao = workTimeDao;
	}

	@Override
	public DataResult<List<WorkTime>> getAll() {
		List<WorkTime> result = this.workTimeDao.findAll();
		return new SuccessDataResult<List<WorkTime>>(result);
	}

	@Override
	public DataResult<WorkTime> getById(int workTimeId) {
		WorkTime result = this.workTimeDao.getById(workTimeId);
		return new SuccessDataResult<WorkTime>(result);
	}

	@Override
	public Result add(WorkTime workTime) {
		this.workTimeDao.save(workTime);
		return new SuccessResult();
	}

}
