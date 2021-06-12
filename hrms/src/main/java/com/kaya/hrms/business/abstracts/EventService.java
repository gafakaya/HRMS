package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Event;

public interface EventService {
	
	DataResult<List<Event>> getAll();
	
	DataResult<List<Event>> getOrderByCreatedAt();
	
	DataResult<List<Event>> getOrderByDateOfEventAsc();
	
	DataResult<List<Event>> getOrderByDateOfEventAsc(int pageNo, int pageSize);
	
	DataResult<List<Event>> getByCompanyidOrderByDateOfEventAsc(int companyId);
	
	Result add(Event event);
}
