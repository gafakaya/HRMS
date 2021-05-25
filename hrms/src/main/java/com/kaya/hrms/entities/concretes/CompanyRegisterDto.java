package com.kaya.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CompanyRegisterDto {
//	TODO: Dto interface implements
	private String companyName;
	private String webSite;
	private String email;
	private String phone;
	private String password;
	private String passwordConfirm;

}
