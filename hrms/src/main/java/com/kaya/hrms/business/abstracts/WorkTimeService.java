package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.WorkTime;

public interface WorkTimeService {
	
	DataResult<List<WorkTime>> getAll();
	
	DataResult<WorkTime> getById(int workTimeId);
	
	Result add(WorkTime workTime);
	
}
