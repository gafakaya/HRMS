package com.kaya.hrms.core.adapters;

import java.time.LocalDate;

import com.kaya.hrms.core.utilities.results.Result;

public interface MernisService {
	
	Result checkIfRealPerson(
			String firstName,
			String lastName,
			String nationalityId,
			LocalDate dayOfBirth);
}
