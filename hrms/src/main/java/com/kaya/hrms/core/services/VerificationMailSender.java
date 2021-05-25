package com.kaya.hrms.core.services;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class VerificationMailSender implements VerificationSender {

	@Override
	public String send(String email) {
		Random rand = new Random();
		String code = String.valueOf(rand.nextInt((10000 - 1000) + 1) + 1000);		
		System.out.println(email + "your validation code: " + code);
		
		return code;
	}

}
