package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.EventService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Event;

@RestController
@RequestMapping("/api/eventsController")
@CrossOrigin
public class EventsController {
	
	private EventService eventService;

	@Autowired
	public EventsController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Event>> getAll() {
		return this.eventService.getAll();
	}
	
	@GetMapping("/getOrderByCreatedAt")
	public DataResult<List<Event>> getOrderByCreatedAt() {
		return this.eventService.getOrderByCreatedAt();
	}
	
	@GetMapping("/getOrderByDateOfEvent")
	public DataResult<List<Event>> getOrderByDateOfEventAsc() {
		return this.eventService.getOrderByDateOfEventAsc();
	}
	
	@GetMapping("/getOrderByDateOfEventAscPage")
	public DataResult<List<Event>> getOrderByDateOfEventAscPage(@RequestParam int pageNo,@RequestParam int pageSize) {
		return this.eventService.getOrderByDateOfEventAsc(pageNo -1 , pageSize);
	}
	
	@GetMapping("getByCompanyidOrderByDateOfEventAsc")
	public DataResult<List<Event>> getByCompanyidOrderByDateOfEventAsc(@RequestParam int companyId) {
		return this.eventService.getByCompanyidOrderByDateOfEventAsc(companyId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Event event) {
		return this.eventService.add(event);
	}
	
	

}
