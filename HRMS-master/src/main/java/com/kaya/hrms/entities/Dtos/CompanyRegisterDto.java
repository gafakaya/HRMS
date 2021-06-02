package com.kaya.hrms.entities.Dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CompanyRegisterDto {

	@NotBlank
	@NotNull
	private String companyName;
	@NotBlank
	@NotNull
	private String webSite;
	@Email
	@NotBlank
	@NotNull
	private String email;
	@NotBlank
	@NotNull
	private String phone;
	@NotBlank
	@NotNull
	private String password;
	@NotBlank
	@NotNull
	private String passwordConfirm;

}
