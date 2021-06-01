package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.DepartmentService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.DepartmentDao;
import com.kaya.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {
	
	private DepartmentDao departmentDao;

	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		List<Department> result = this.departmentDao.findAll();
		return new SuccessDataResult<List<Department>>(result);
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult();
	}

}
