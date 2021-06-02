package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Workplace;

public interface WorkplaceService {

	DataResult<List<Workplace>> getAll();
	
	Result add(Workplace workplace);
	
}
