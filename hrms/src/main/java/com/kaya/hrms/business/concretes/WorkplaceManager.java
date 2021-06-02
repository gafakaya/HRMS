package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.WorkplaceService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.WorkplaceDao;
import com.kaya.hrms.entities.concretes.Workplace;

@Service
public class WorkplaceManager implements WorkplaceService {

	private WorkplaceDao workplaceDao;
	
	@Autowired
	public WorkplaceManager(WorkplaceDao workplaceDao) {
		this.workplaceDao = workplaceDao;
	}

	@Override
	public DataResult<List<Workplace>> getAll() {
		List<Workplace> result = this.workplaceDao.findAll();
		return new SuccessDataResult<List<Workplace>>(result);
	}

	@Override
	public Result add(Workplace workplace) {
		this.workplaceDao.save(workplace);
		return new SuccessResult();
	}

	
	
}
