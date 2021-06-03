package com.kaya.hrms.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kaya.hrms.core.utilities.helpers.imageHelper.ImageUploadService;
import com.kaya.hrms.core.utilities.helpers.imageHelper.cloudinary.CloudinaryImageManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfiguration {

//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper;
//    }

//    @Bean
//    public ValidatePersonService validatePersonService(){
//        return new ValidatePersonMernisAdapter();
//    }

//    @Bean
//    public MailService mailService(){
//        return new MailManager();
//    }

	public Environment environment;
	
    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "kayacloud",
                "api_key", "145833796223714",
                "api_secret", "LmT077iSmsA36cC70R8i9ItVSHE"));
    }

    @Bean
    public ImageUploadService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}