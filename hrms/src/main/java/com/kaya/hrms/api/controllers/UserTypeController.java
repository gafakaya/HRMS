package com.kaya.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.UserTypeService;

@RestController
@RequestMapping("/api/userTypesController")
@CrossOrigin
public class UserTypeController {
	
	private UserTypeService userTypeService;

	public UserTypeController(UserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}
	
	

}
