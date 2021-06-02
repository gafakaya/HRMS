package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Department;

public interface DepartmentService {
	
	DataResult<List<Department>> getAll();
	
	Result add(Department department);
}
