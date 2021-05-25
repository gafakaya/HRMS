package com.kaya.hrms.business.concretes;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaya.hrms.business.abstracts.EmailActivationCodeService;
import com.kaya.hrms.core.utilities.results.ErrorResult;
import com.kaya.hrms.core.utilities.results.Result;
import com.kaya.hrms.core.utilities.results.SuccessResult;
import com.kaya.hrms.dataAccess.abstracts.EmailActivationCodeDao;
import com.kaya.hrms.entities.concretes.EmailActivationCode;

@Service
public class EmailActivationCodeManager implements EmailActivationCodeService {
	
    private EmailActivationCodeDao emailActivationCodeDao;

    @Autowired
    public EmailActivationCodeManager(EmailActivationCodeDao emailActivationCodeDao) {
        this.emailActivationCodeDao = emailActivationCodeDao;
    }
//
//    @Override
//    public DataResult<EmailActivationCode> getById(Integer id){
//        return new SuccessDataResult<EmailActivationCode>
//                (this.emailActivationCodeDao.findById(id).get(), "Veriler Listelendi");
//    }

  /*  public String codeGenerator() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 30;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }*/




    public Result getById(Integer id, String activationCode) {
//        String token = UUID.randomUUID().toString();

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 32;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        String token = generatedString;


        Optional<EmailActivationCode> emailActivationCodeOptional = emailActivationCodeDao.findByIdAndEmailActivationCode(id, activationCode);
        boolean isEmailActivation = emailActivationCodeOptional.isPresent();

        if(!isEmailActivation) {
            return new ErrorResult("localhost:8080/api/users/" + id + "/" + activationCode + " Böyle bir kullanıcı yok" + "Gönderdiğin Parametre ID: " + id + " token: " + token);
        }
        EmailActivationCode emailActivationCode = emailActivationCodeOptional.get();
        if(emailActivationCode.getEmailExpirationDate().isBefore(LocalDate.now())){
            return new ErrorResult("localhost:8080/api/users/" + id + "/" + activationCode + " Süre geçmiş. UUID: " + token);
        }
        emailActivationCode.setEmailIsConfirmed(true);
        emailActivationCode.setEmailConfirmedDate(LocalDate.now());
        emailActivationCodeDao.save(emailActivationCode);
        return new SuccessResult("localhost:8080/api/users/" + id + "/" + activationCode) ;

//        LocalDate.now().plusDays(3);
    }
}
