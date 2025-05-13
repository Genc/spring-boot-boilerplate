package com.hiringglobal.mobile.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 255)
	private String letter;
	
	@Column(length = 255)
	private String linkCV;

	@ManyToOne
	@JoinColumn(name = "applicant_id",  nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Applicant applicant;
	
	private LocalDateTime applyDate;
	
	private Boolean isApproved;
	
	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Job job;

	@ManyToMany
	private Set<Category> categories;

	public Application() {

	}
	
	public Application(Integer id, String letter, String linkCV, Applicant applicant, Job job) {
		this.id = id;
		this.letter = letter;
		this.linkCV = linkCV;
		this.applicant = applicant;
		this.job = job;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getLinkCV() {
		return linkCV;
	}

	public void setLinkCV(String linkCV) {
		this.linkCV = linkCV;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public LocalDateTime getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDateTime applyDate) {
		this.applyDate = applyDate;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
