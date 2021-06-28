package com.kaya.hrms.entities.Dtos.SocialMediaDtos;

import java.time.LocalDate;

import com.kaya.hrms.entities.Dtos.JobSeekerDtos.JobSeekerUpdateDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SocialMediaAddDto {

	private String link;
	private int jobSeekerId;
	private int linkTypeId;

}
