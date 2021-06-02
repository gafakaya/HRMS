package com.kaya.hrms.business.concretes;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.VerificationService;
import com.kaya.hrms.business.constants.Messages;
import com.kaya.hrms.core.services.VerificationSender;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.entities.concretes.Company;

@Service
public class VerificationManager implements VerificationService {

	private VerificationSender verificationSender;
	static Scanner scan = new Scanner(System.in);
	
	@Autowired
	public VerificationManager(VerificationSender verificationSender) {
		this.verificationSender = verificationSender;
	}

	@Override
	public Result verificateMail(String email) {
		
		String verifitionCode = this.verificationSender.send(email);
		
		String code = "";
		
		try {
			Thread.sleep(1000);
			code = verifitionCode;
			
		} catch (Exception e) {
			System.out.println("An unexpected error has occurred.");
			throw new IllegalStateException(e.getMessage());
		}
		
		try {
			System.out.println("Enter the verification code sent: ");
			String enteredCode = scan.nextLine();
			if(!code.equals(enteredCode)) {
				return new ErrorResult(Messages.ERROR_VERIFICATION_CODE_UNMATCHED);
			}
			
		} catch (Exception e) {
			System.out.println("An unexpected error has occurred.");
			throw new IllegalStateException(e.getMessage());
		}
		
		return new SuccessResult();
	}

	@Override
	public Result companyVerificationByEmployee(Company company) {
		
		String companyName = company.getCompanyName();
		String webSite = company.getWebSite();
		String email = company.getEmail();
		String phone = company.getPhone();
		
		String delayed = "-";
		String denied = "n";
				
		try {
			System.out.println("Company Information: \n\n");
			System.out.println("Company Name: " + companyName +
							   "\nCompany Web Site: " + webSite + 
							   "\nCompany Email: " + email + 
							   "\nCompany Phone Number: " + phone);
			System.out.println("Do you confirm: (y/n/-)");
			String entered = scan.nextLine();
			if(entered.equals(delayed)) {
				return new ErrorResult(Messages.COMPANY_CONFIRMATION_IS_DELAYED);
			} else if (entered.equals(denied)) {
				return new ErrorResult(Messages.COMPANY_CONFIRMATION_IS_DENIED);
			}
			
		} catch (Exception e) {
			System.out.println("An unexpected error has occurred.");
			throw new IllegalStateException(e.getMessage());
		}
		
		return new SuccessResult(Messages.COMPANY_CONFIRMATION_IS_ACCEPTED);
	}
	
	
	

}
