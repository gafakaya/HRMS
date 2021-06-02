package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.AbilityService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.AbilityDao;
import com.kaya.hrms.entities.concretes.Ability;

@Service
public class AbilityManager implements AbilityService {

	private AbilityDao abilityDao;
	
	@Autowired
	public AbilityManager(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}

	@Override
	public DataResult<List<Ability>> getAll() {
		List<Ability> result = this.abilityDao.findAll();
		return new SuccessDataResult<List<Ability>>(result);
	}

	@Override
	public Result add(Ability ability) {
		this.abilityDao.save(ability);
		return new SuccessResult();
	}

}
