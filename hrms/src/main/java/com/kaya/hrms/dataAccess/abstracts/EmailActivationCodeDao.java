package com.kaya.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaya.hrms.entities.concretes.EmailActivationCode;

public interface EmailActivationCodeDao extends JpaRepository<EmailActivationCode, Integer> {

    Optional<EmailActivationCode>  findByIdAndEmailActivationCode(
    		Integer integer,
    		String activationCode);
}
