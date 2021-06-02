package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.Workplace;

public interface WorkplaceDao extends JpaRepository<Workplace, Integer> {

}
