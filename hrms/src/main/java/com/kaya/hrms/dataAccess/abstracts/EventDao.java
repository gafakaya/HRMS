package com.kaya.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.Event;

public interface EventDao extends JpaRepository<Event, Integer> {

	List<Event> findByOrderByCreatedAtDesc();
	
	List<Event> findByOrderByDateOfEventAsc();
	
	Page<Event> findByOrderByDateOfEventAsc(Pageable pageable);
	
	List<Event> findByCompany_idOrderByDateOfEventAsc(int companyId);
	
}
