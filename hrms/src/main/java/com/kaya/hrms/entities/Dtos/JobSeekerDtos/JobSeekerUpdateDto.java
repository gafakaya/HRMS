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
public class JobSeekerUpdateDto {
	
	private String firstName;
	private String lastName;
	private LocalDate dayOfBirth;
	private String email;

}
