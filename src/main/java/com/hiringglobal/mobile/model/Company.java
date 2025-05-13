package com.hiringglobal.mobile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 255)
	private String name;

	@Column(length = 255)
	private String contact;

	@Column(length = 255)
	private String logo;

	@Column(columnDefinition = "TEXT")
	private String introduction;

	@Column(length = 255)
	private String address;

	private String email;
	
	private String website;
	
	@OneToOne
	@JoinColumn(name = "recruiter_id", nullable = false)
	private Recruiter recruiter;

	public Company() {
	}

	public Company(Integer id, String name, String contact, String logo, String introduction, String address,
			Recruiter recruiter, String email, String website) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.logo = logo;
		this.introduction = introduction;
		this.address = address;
		this.recruiter = recruiter;
		this.email = email;
		this.website = website;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
}
