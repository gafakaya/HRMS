package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	
	DataResult<List<WorkType>> getAll();
	
	DataResult<WorkType> getById(int workTypeId);
	
	Result add(WorkType workType);
	
}
