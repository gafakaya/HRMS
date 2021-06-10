package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobAdvertisementApplication;

public interface JobAdvertisementApplicationDao extends JpaRepository<JobAdvertisementApplication, Integer> {

}
