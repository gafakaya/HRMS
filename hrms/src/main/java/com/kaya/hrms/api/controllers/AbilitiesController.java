package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.AbilityService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.Ability;

@RestController
@RequestMapping("/api/abilitiesController")
public class AbilitiesController {


	private AbilityService abilityService;

	@Autowired
	public AbilitiesController(AbilityService abilityService) {
		this.abilityService = abilityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Ability>> getAll() {
		return this.abilityService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Ability ability) {
		return this.abilityService.add(ability);
	}
	
	
	
}
