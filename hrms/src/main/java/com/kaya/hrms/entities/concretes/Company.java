package com.kaya.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaya.hrms.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Company extends User {

	@Column(name="web_site")
	private String webSite;
	@Column(name="phone")
	private String phone;
	@Column(name="company_name")
	private String companyName;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="confirm")
	private boolean confirm;

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<JobAdvertisement> jobAdvertisements;
	
	public Company(
			int id,
			String email,
			String password,
			LocalDate createdAt,
			String companyName,
			String webSite,
			String phone,
			boolean isActive,
			boolean confirm) {
		super(id, email, password, createdAt);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phone = phone;
		this.isActive = isActive;
		this.confirm = confirm;
	}
}
