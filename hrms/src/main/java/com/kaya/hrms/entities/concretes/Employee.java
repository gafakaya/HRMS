package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaya.hrms.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User {
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	
	public Employee(
			int id,
			String email,
			String password,
			LocalDate createdAt,
			String firstName,
			String lastName) {
		super(id, email, password, createdAt);
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
