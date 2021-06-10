package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.JobAdvertisementComment;

public interface JobAdvertisementCommentDao extends JpaRepository<JobAdvertisementComment, Integer> {

}
