package com.kaya.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.EventService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.EventDao;
import com.kaya.hrms.entities.concretes.Event;


@Service
public class EventManager implements EventService{
	
	private EventDao eventDao;

	@Autowired
	public EventManager(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public DataResult<List<Event>> getAll() {
		List<Event> result = this.eventDao.findAll();
		return new SuccessDataResult<List<Event>>(result, Messages.EVENT_LISTED);
	}

	@Override
	public DataResult<List<Event>> getOrderByCreatedAt() {
		List<Event> result = this.eventDao.findByOrderByCreatedAtDesc();
		return new SuccessDataResult<List<Event>>(result, Messages.EVENT_LISTED_ORDER_BY_CREATED_AT_DESC);
	}

	@Override
	public DataResult<List<Event>> getOrderByDateOfEventAsc() {
		List<Event> result = this.eventDao.findByOrderByDateOfEventAsc();
		return new SuccessDataResult<List<Event>>(result, Messages.EVENT_LISTED_ORDER_BY_DATE_OF_EVENT_ASC);
	}

	@Override
	public DataResult<List<Event>> getOrderByDateOfEventAsc(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		List<Event> result = this.eventDao.findByOrderByDateOfEventAsc(pageable).getContent();
		
		return new SuccessDataResult<List<Event>>(result, Messages.EVENT_PAGED_ORDER_BY_DATE_OF_EVENT_ASC);
	}

	@Override
	public DataResult<List<Event>> getByCompanyidOrderByDateOfEventAsc(int companyId) {
		List<Event> result = this.eventDao.findByCompany_idOrderByDateOfEventAsc(companyId);
		return new SuccessDataResult<List<Event>>(result, Messages.EVENT_LISTED_BY_COMPANY_ID_ORDER_BY_DATE_OF_EVENT_ASC);
	}


	@Override
	public Result add(Event event) {
		event.setCreatedAt(LocalDateTime.now());
		LocalDateTime dateOfEvent = event.getDateOfEvent();
		if(dateOfEvent.isBefore(LocalDateTime.now()) || dateOfEvent.isEqual(LocalDateTime.now())) {
			return new ErrorResult(Messages.ERROR_EVENT_DATE_OUT_OF_DATE);
		}
		this.eventDao.save(event);
		return new SuccessResult(Messages.EVENT_ADDED);
	}
}
