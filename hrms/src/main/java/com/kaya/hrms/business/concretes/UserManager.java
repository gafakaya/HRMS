package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.UserService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.dataAccess.abstracts.UserDao;
import com.kaya.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
    private UserDao<User, Integer> userDao;

    @Autowired
    public UserManager(UserDao<User, Integer> userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
    	List<User> result = this.userDao.findAll();
        return new SuccessDataResult<List<User>>(result);
    }
}
