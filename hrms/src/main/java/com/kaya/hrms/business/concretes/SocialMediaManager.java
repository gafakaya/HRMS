package com.kaya.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.SocialMediaService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.SocialMediaDao;
import com.kaya.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		List<SocialMedia> result = this.socialMediaDao.findAll();
		return new SuccessDataResult<List<SocialMedia>>(result);
	}

	@Override
	public DataResult<List<SocialMedia>> getByJobSeeker_id(int jobSeekerId) {
		List<SocialMedia> result = this.socialMediaDao.getByJobSeeker_id(jobSeekerId);
		return new SuccessDataResult<List<SocialMedia>>(result);
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult();
	}

}
