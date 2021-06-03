package com.kaya.hrms.business.abstracts;

import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.CvDto;

public interface CvDtoService {

	Result add(CvDto cvDto);

}
