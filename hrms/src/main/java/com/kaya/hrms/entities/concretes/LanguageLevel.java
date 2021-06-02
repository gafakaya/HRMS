package com.kaya.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="language_levels")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerLanguages"})
public class LanguageLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_level_id")
	private int languageLevelId;
	
	@Column(name="language_level")
	private String languageLevel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "languageLevel")
	private List<JobSeekerLanguage> jobSeekerLanguages;
	
	
}
