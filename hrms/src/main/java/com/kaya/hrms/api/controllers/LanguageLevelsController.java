package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.LanguageLevelService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.LanguageLevel;

@RestController
@RequestMapping("api/languageLevelsController")
public class LanguageLevelsController {
	
	private LanguageLevelService languageLevelService;

	@Autowired
	public LanguageLevelsController(LanguageLevelService languageLevelService) {
		this.languageLevelService = languageLevelService;
	}
	// Deneme 2
	@GetMapping("/getAll")
	public DataResult<List<LanguageLevel>> getAll() {
		return this.languageLevelService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody LanguageLevel languageLevel) {
		return this.languageLevelService.add(languageLevel);
	}

}
