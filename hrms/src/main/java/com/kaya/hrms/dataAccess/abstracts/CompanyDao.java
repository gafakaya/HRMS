package com.kaya.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaya.hrms.entities.concretes.Company;

public interface CompanyDao extends UserDao<Company, Integer> {

	Optional<Company> findByEmail(String email);
	
}
