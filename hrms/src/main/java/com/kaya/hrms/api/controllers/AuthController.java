package com.kaya.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.concretes.AuthManager;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.utilities.results.ErrorDataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.CompanyRegisterDto;
import com.kaya.hrms.entities.Dtos.JobSeekerRegisterDto;

@RestController
@RequestMapping("/api/")
public class AuthController {
	
	private AuthManager authManager;

	public AuthController(AuthManager authManager) {
		this.authManager = authManager;
	}
	
	@PostMapping("jobseekers/register")
	public ResponseEntity<?> jobSeekerRegister(
			@Valid @RequestBody JobSeekerRegisterDto jobSeekerDto) {
		Result result = this.authManager.jobSeekerRegister(jobSeekerDto);
		return ResponseEntity.ok(result);
	}
	
	
	@PostMapping("companies/register")
	public ResponseEntity<?> companyRegister(
			@Valid @RequestBody CompanyRegisterDto companyDto) {
		Result result = this.authManager.companyRegister(companyDto);
		return ResponseEntity.ok(result);
	}
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ErrorDataResult<Object> handleValidationExcaption(
//			MethodArgumentNotValidException exceptions) {
//		
//		Map<String, String> validationErrors = new HashMap<String, String>();
//		
//		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
//			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
//		}
//		
//		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(
//				validationErrors, Messages.ERROR_VALIDATION);
//		
//		return errors;
//	}
	
	
	

}
