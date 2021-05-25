package com.kaya.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.hrms.business.abstracts.EmailActivationCodeService;
import com.kaya.hrms.business.abstracts.UserService;
import com.kaya.hrms.core.utilities.results.DataResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    private EmailActivationCodeService emailActivationCodeService;

    @Autowired
    public UserController(UserService userService,EmailActivationCodeService emailActivationCodeService) {
        this.userService = userService;
        this.emailActivationCodeService = emailActivationCodeService;
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

//    @PostMapping("/add")
//    public Result getAll(){
//        return this.userService.getAll();
    //    return new DataResult(this.userService.getAll(), True, "Başarılı")
//    }

    @GetMapping("/{id}/{activationCode}")
    public Result getById(
    		@PathVariable Integer id,
    		@PathVariable String activationCode){
        return this.emailActivationCodeService
        		.getById(id, activationCode );

    }


}
