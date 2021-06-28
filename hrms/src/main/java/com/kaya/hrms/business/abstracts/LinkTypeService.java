package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.LinkType;

public interface LinkTypeService {
	
	DataResult<List<LinkType>> getAll();
	
	DataResult<LinkType> getById(int linkTypeId);

	Result add(LinkType linkType);
}
