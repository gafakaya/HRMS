package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.LanguageLevel;

public interface LanguageLevelService {
	
	DataResult<List<LanguageLevel>> getAll();
	
	Result add(LanguageLevel languageLevel);
}
