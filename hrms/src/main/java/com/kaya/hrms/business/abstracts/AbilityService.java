package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Ability;

public interface AbilityService {
	
	DataResult<List<Ability>> getAll();
	
	Result add(Ability ability);

}
