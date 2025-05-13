package com.hiringglobal.mobile.dto;

import com.hiringglobal.mobile.model.Application;
import com.hiringglobal.mobile.model.Category;
import com.hiringglobal.mobile.model.Location;
import com.hiringglobal.mobile.model.Recruiter;

import java.time.LocalDate;
import java.util.List;

public class PostJobDTO {
	private Integer id;
	private String title;
	private String description;
	private String contact;
	private String salary;
	private String jobTags;
	private String jobDetail;
	private LocalDate datePost;
	private LocalDate closedDate;
	private String workingTime;
	private List<Location> locations;
	private List<Integer> locationIds;
	private Boolean hidden;
	private String fullname;
	private String email;
	private String phone;
	private String address;
	private Category category;
	private AccountDTO account;
	private Integer numberApplications;
	private Recruiter recruiter;
	private List<Application> applications;
	private Boolean isAccepted;
	public PostJobDTO() {

	}

	public PostJobDTO(Integer id, String title, String description, String contact, String salary, String jobTags,
			String jobDetail, LocalDate datePost, LocalDate closedDate, String workingTime, List<Location> locations,
			List<Integer> locationIds, Boolean hidden, String fullname, String email, String phone, String address,
			Category category, AccountDTO account) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.contact = contact;
		this.salary = salary;
		this.jobTags = jobTags;
		this.jobDetail = jobDetail;
		this.datePost = datePost;
		this.closedDate = closedDate;
		this.workingTime = workingTime;
		this.locations = locations;
		this.locationIds = locationIds;
		this.hidden = hidden;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.category = category;
		this.account = account;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getJobTags() {
		return jobTags;
	}

	public void setJobTags(String jobTags) {
		this.jobTags = jobTags;
	}

	public String getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(String jobDetail) {
		this.jobDetail = jobDetail;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public List<Integer> getLocationIds() {
		return locationIds;
	}

	public void setLocationIds(List<Integer> locationIds) {
		this.locationIds = locationIds;
	}

	public LocalDate getDatePost() {
		return datePost;
	}

	public void setDatePost(LocalDate datePost) {
		this.datePost = datePost;
	}

	public LocalDate getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(LocalDate closedDate) {
		this.closedDate = closedDate;
	}

	public Integer getNumberApplications() {
		return numberApplications;
	}

	public void setNumberApplications(Integer numberApplications) {
		this.numberApplications = numberApplications;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
	public boolean checkLocation(Location location) {
		return locations.stream().filter(loc->location.getId()==loc.getId()).findAny().isPresent();
	}

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
}
