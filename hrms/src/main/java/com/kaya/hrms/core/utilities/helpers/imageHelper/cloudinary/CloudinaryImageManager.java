package com.kaya.hrms.core.utilities.helpers.imageHelper.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kaya.hrms.core.utilities.helpers.imageHelper.ImageUploadService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.ErrorDataResult;
import com.kaya.hrms.core.utilities.results.SuccessDataResult;

public class CloudinaryImageManager implements ImageUploadService {

	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryImageManager(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}
	
	@Override
    public DataResult<Map> save(MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
            ;
            return new SuccessDataResult<Map>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }
	

}
