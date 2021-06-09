package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kaya.hrms.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisement_comments")
public class JobAdvertisementComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advertisement_comment_id")
	private int jobAdvertisementCommentId;
	
	@ManyToOne
	@JoinColumn(name="job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="content")
	private String content;
	
	@Column(name="like")
	private int like;
	
	@Column(name="dislike")
	private int dislike;
	
	@Column(name="createAt")
	private LocalDateTime createAt;

}
