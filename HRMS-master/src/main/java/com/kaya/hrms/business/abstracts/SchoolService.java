package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.School;

public interface SchoolService {
	
	DataResult<List<School>> getAll();
	
	Result add(School school);

}
