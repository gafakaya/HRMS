package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.CvDto;

public interface CvDtoService {

	DataResult<List<CvDto>> getAll();
	
	DataResult<CvDto> getByJobSeekerId(int jobSeekerId);

	Result add(CvDto cvDto);

}
