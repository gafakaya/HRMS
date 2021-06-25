package com.kaya.hrms.entities.Dtos.JobAdvertisementDtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementUpdateDto {
	
	private int JobTitleId;
	private int cityId;
	private String jobDescription;
	private int numberOfOpenPositions;
	private LocalDate applicationDeadline;
	private int workTimeId;
	private int workTypeId;
	private int maxSalary;
	private int minSalary;
	private boolean enable;
	private boolean confirm;

}
