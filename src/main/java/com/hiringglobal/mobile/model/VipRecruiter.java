package com.hiringglobal.mobile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vip_recruiter")
public class VipRecruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Integer pricing;

	@Column(length = 255)
	private String name;

	private Integer during;

	private Integer limitedPosts;

	private Integer limitedApplications;

	private Integer priority;

	private Boolean supported = true;

	public VipRecruiter() {

	}

	public VipRecruiter(Integer id, Integer pricing, String name, Integer during, Integer limitedPosts,
			Integer limitedApplications, Integer priority, Boolean supported) {
		this.id = id;
		this.pricing = pricing;
		this.name = name;
		this.during = during;
		this.limitedPosts = limitedPosts;
		this.limitedApplications = limitedApplications;
		this.priority = priority;
		this.supported = supported;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPricing() {
		return pricing;
	}

	public void setPricing(Integer pricing) {
		this.pricing = pricing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuring() {
		return during;
	}

	public void setDuring(Integer during) {
		this.during = during;
	}

	public Integer getLimitedPosts() {
		return limitedPosts;
	}

	public void setLimitedPosts(Integer limitedPosts) {
		this.limitedPosts = limitedPosts;
	}

	public Integer getLimitedApplications() {
		return limitedApplications;
	}

	public void setLimitedApplications(Integer limitedApplications) {
		this.limitedApplications = limitedApplications;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Boolean getSupported() {
		return supported;
	}

	public void setSupported(Boolean supported) {
		this.supported = supported;
	}

	

}
