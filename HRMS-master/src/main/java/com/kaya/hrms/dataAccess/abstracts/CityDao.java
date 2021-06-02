package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
