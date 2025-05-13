package com.hiringglobal.mobile.dto;

import com.hiringglobal.mobile.model.Category;
import com.hiringglobal.mobile.model.Location;
import com.hiringglobal.mobile.model.Recruiter;

import java.sql.Date;
import java.util.List;

public class JobDTO {
	private Integer id;
	private String title;
	private String salary;
	private String contact;
	private String jobTags;
	private String description;
	private String jobDetail;
	private Date closedDate;

	private String workingTime;
	private List<Location> locations;

	private Boolean hidden;

	private Boolean isAccepted;

	private Category category;

	private Recruiter recruiter;

	public JobDTO() {

	}

	public JobDTO(Integer id, String title, String salary, String contact, String jobTags, String description,
			String jobDetail, Date closedDate, String workingTime, List<Location> locations, Boolean hidden,
			Boolean isAccepted, Category category, Recruiter recruiter) {
		this.id = id;
		this.title = title;
		this.salary = salary;
		this.contact = contact;
		this.jobTags = jobTags;
		this.description = description;
		this.jobDetail = jobDetail;
		this.closedDate = closedDate;
		this.workingTime = workingTime;
		this.locations = locations;
		this.hidden = hidden;
		this.isAccepted = isAccepted;
		this.category = category;
		this.recruiter = recruiter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getJobTags() {
		return jobTags;
	}

	public void setJobTags(String jobTags) {
		this.jobTags = jobTags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(String jobDetail) {
		this.jobDetail = jobDetail;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

}
