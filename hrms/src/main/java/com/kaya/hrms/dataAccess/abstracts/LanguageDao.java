package com.kaya.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaya.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
