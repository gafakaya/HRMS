package com.kaya.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools_departments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerSchoolDepartments"})
public class SchoolDepartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="schools_department_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy = "schoolDepartment")
	private List<JobSeekerSchoolDepartment> jobSeekerSchoolDepartments;
	

}
