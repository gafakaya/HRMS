package com.kaya.hrms.core.adapters;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.kaya.hrms.Mernis.MernisManager;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisManagerAdapter implements MernisService {

	public Result checkIfRealPerson(
			String firstName,
			String lastName,
			String nationalityId,
			LocalDate dayOfBirth) {
		
		MernisManager mernisManager = new MernisManager();
		
		boolean result = mernisManager.validateWithMernis(
				firstName,
				lastName,
				nationalityId,
				dayOfBirth);
		
		if (!result) {
			return new ErrorResult("This person is not real.");
		}
		
		return new SuccessResult();
		
		
	}
	
	
	
	
}
