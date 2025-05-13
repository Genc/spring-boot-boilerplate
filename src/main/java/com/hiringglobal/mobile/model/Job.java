package com.hiringglobal.mobile.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String title;

    @Column(length = 255)
    private String salary;

    @Column(length = 255)
    private String contact;

    @Column(length = 255)
    private String workingTime;
    
	@Column(length = 255)
	private String jobTags;

	private LocalDate datePost;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(columnDefinition = "TEXT")
	private String jobDetail;

	private LocalDate closedDate;

    private Integer priority;

	private Boolean isAccepted;
	
	private Boolean hidden;
	
	@ManyToMany
	@JoinTable(name = "job_location", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "location_id"))
	private Set<Location> locations;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;


    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Recruiter recruiter;


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


	public String getWorkingTime() {
		return workingTime;
	}


	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
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

	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Boolean getIsAccepted() {
		return isAccepted;
	}


	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


	public Boolean getHidden() {
		return hidden;
	}


	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}


	public Set<Location> getLocations() {
		return locations;
	}


	public void setLocations(Set<Location> locations) {
		this.locations = locations;
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

	public String getCompanyName() {
		return recruiter.getCompany().getName();
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



}
