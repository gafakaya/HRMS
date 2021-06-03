package com.kaya.hrms.core.utilities.helpers.imageHelper;

import org.springframework.web.multipart.MultipartFile;

import com.kaya.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	
	DataResult<?> save(MultipartFile image);

}
