package com.kaya.hrms.entities.Dtos;

import java.time.LocalDate;

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
	private int numberOfOpenPositions;
	private LocalDate createdAt;
	private LocalDate applicaitonDateline;

}
