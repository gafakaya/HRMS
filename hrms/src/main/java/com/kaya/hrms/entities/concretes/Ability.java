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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "abilities")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerAbilities"})
public class Ability {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ability_id")
	private int abilityId;
	
	@Column(name="ability_name")
	private String abilityName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ability")
	private List<JobSeekerAbility> jobSeekerAbilities;

}
