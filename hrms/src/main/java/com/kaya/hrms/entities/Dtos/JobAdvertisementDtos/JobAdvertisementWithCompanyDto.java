package com.kaya.hrms.entities.Dtos.JobAdvertisementDtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithCompanyDto {
	
	private int id;
	private String companyName;
	private String title;
	private String cityName;
	private String jobDescription;
	private int like;
	private int numberOfOpenPositions;
	private LocalDateTime createdAt;
	private LocalDate applicationDeadline;
	private String workTime;
	private String workType;
	private int maxSalary;
	private int minSalary;
	
}
