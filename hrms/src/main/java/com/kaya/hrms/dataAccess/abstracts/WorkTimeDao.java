package com.kaya.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.WorkTime;
import com.kaya.hrms.entities.concretes.WorkType;

public interface WorkTimeDao  extends JpaRepository<WorkTime, Integer>{

	Optional<WorkTime> findByWorkTimeId(int workTimeId);
	
}
