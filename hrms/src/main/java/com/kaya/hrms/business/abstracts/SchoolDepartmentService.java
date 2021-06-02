package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentService {
	
	DataResult<List<SchoolDepartment>> getAll();
	
	Result add(SchoolDepartment schoolDepartment);

}
