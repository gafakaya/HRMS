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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="link_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","socialMedias"})
public class LinkType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="link_type_id")
	private int linkTypeId;
	
	@Column(name="link_type_name")
	private String linkTypeName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "linkType")
	private List<SocialMedia> socialMedias;
	
}
