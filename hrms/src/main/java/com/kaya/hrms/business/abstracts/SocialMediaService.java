package com.kaya.hrms.business.abstracts;

import java.util.List;

import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.Dtos.SocialMediaDtos.SocialMediaAddDto;
import com.kaya.hrms.entities.Dtos.SocialMediaDtos.SocialMediaUpdateDto;
import com.kaya.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	
	DataResult<List<SocialMedia>> getAll();
	
	DataResult<List<SocialMedia>> getByJobSeeker_id(int jobSeekerId);
	
	Result add(SocialMedia socialMedia);

	Result update(SocialMedia socialMedia);
}
