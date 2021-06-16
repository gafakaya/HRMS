package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.WorkTypeService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.WorkTypeDao;
import com.kaya.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService {
	
	private WorkTypeDao workTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		this.workTypeDao = workTypeDao;
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		List<WorkType> result = this.workTypeDao.findAll();
		return new SuccessDataResult<List<WorkType>>(result);
	}

	@Override
	public DataResult<WorkType> getById(int workTypeId) {
		WorkType result = this.workTypeDao.getById(workTypeId);
		return new SuccessDataResult<WorkType>(result);
	}

	@Override
	public Result add(WorkType workType) {
		this.workTypeDao.save(workType);
		return new SuccessResult();
	}

	
	
}
