package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.entities.concretes.User;

public interface UserService {
	
    DataResult<List<User>> getAll();
    
}
