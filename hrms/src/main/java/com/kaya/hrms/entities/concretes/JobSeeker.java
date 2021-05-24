package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@NoArgsConstructor
@AllArgsConstructor
public class JobSeeker extends User {

	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="nationality_id")
	private String nationalityId;
	@Column(name="day_of_birth")
	private LocalDate dayOfBirth;
	@Column(name="is_confirm")
	private boolean isConfirm;
	
	public JobSeeker(
			int id,
			String email,
			String password,
			LocalDate createdAt,
			String firstName,
			String lastName,
			String nationalityId,
			LocalDate dayOfBirth,
			boolean isConfirm) {
		super(id, email, password, createdAt);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dayOfBirth = dayOfBirth;
		this.isConfirm = isConfirm;
	}
	
}
