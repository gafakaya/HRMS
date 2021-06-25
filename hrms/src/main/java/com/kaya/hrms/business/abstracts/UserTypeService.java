package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.entities.concretes.UserType;

public interface UserTypeService {
	
	DataResult<List<UserType>> getAll();
	
	DataResult<UserType> getById(int userTypeId);

}
