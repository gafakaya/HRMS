package com.kaya.hrms.core.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaya.hrms.core.entities.User;

@Repository
public interface UserDao<T extends User, ID> extends JpaRepository<T, ID> {

	Optional<T> findByEmail(String email);
	
	Optional<T> findById(String id);
	
}
