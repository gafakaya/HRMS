package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.CityService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.CityDao;
import com.kaya.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		List<City> result = this.cityDao.findAll();
		
		return new SuccessDataResult<List<City>>(
				result,
				Messages.CITY_LISTED);
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult(Messages.CITY_ADDED);
	}

}
