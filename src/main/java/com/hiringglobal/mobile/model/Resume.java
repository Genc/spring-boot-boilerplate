package com.hiringglobal.mobile.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="resumes")
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "TEXT")
	private String description;
	@Column(length = 255)
	private String university;
	@Column(length = 10)
	private String phone;
	@Column(length = 255)
	private String address;
	@Column(length = 255)
	private String website;

	@Column(nullable = false)
	private Boolean status;

	@OneToMany(mappedBy="resume",orphanRemoval = true,cascade = CascadeType.ALL)
	private List<CV> cvList=new ArrayList<>() ;

	@OneToOne
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;

	public Resume(){

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<CV> getCvList() {
		return cvList;
	}

	public void setCvList(List<CV> cvList) {
		this.cvList = cvList;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
}

