package com.kaya.hrms.entities.Dtos.JobSeekerDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class JobSeekerRegisterDto {
	private String firstName;
	private String lastName;
	private String nationalityId;
	private LocalDate dayOfBirth;
	private String email;
	private String password;
	private String passwordConfirm;
}
