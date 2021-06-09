package com.kaya.hrms.core.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaya.hrms.entities.concretes.JobAdvertisementComment;
import com.kaya.hrms.entities.concretes.JobSeekerWorkplaceTitle;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name="created_at")
	private LocalDate createdAt;
	
	public User(int id,
			String email,
			String password,
			LocalDate createdAt) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}
	

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<JobAdvertisementComment> jobAdvertisementComments;
	

}
