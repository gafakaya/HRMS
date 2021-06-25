package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.UserTypeService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.dataAccess.abstracts.UserTypeDao;
import com.kaya.hrms.entities.concretes.UserType;

@Service
public class UserTypeManager implements UserTypeService {
	
	private UserTypeDao userTypeDao;
	
	@Autowired
	public UserTypeManager(UserTypeDao userTypeDao) {
		this.userTypeDao = userTypeDao;
	}

	@Override
	public DataResult<List<UserType>> getAll() {
		List<UserType> result = this.userTypeDao.findAll();
		return new SuccessDataResult<List<UserType>>(result);
	}

	@Override
	public DataResult<UserType> getById(int userTypeId) {
		UserType result = this.userTypeDao.getById(userTypeId);
		return new SuccessDataResult<UserType>(result);
	}

}
