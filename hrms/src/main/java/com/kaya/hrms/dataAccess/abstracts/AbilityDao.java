package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer> {

}
