package com.kaya.hrms.entities.Dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithCompanyDto {
	
	private String companyName;
	private String title;
	private String cityName;
	private String jobDescription;
	private int like;
	private int numberOfOpenPositions;
	private LocalDateTime createdAt;
	private LocalDate applicaitonDateline;

}
