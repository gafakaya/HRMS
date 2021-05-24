package com.kaya.hrms.business.validationRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessResult;

public class EmailValidator {
	
	public static Result jobSeekerEmailValid(String email) {
		Pattern VALID_EMAIL_TYPE = 
				Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
						Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = VALID_EMAIL_TYPE.matcher(email);
		if (!matcher.matches()) {
			return new ErrorResult(Messages.ERROR_JOB_SEEKER_EMAIL_INVALID);
		}
		
		return new SuccessResult();
	}
	
	public static Result companyEmailValid(String email, String companyName) {
		Pattern VALID_EMAIL_TYPE = 
				Pattern.compile("^[A-Z0-9._%+-]+@[" + companyName + "]+\\.[A-Z]{2,6}$",
						Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = VALID_EMAIL_TYPE.matcher(email);
		if (!matcher.matches()) {
			return new ErrorResult(Messages.ERROR_COMPANY_EMAIL_INVALID);
		}
		
		return new SuccessResult();
	}
}
