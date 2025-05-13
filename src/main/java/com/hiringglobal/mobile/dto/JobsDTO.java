package com.hiringglobal.mobile.dto;

import com.hiringglobal.mobile.model.Location;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JobsDTO {
    private Integer id;

    public JobsDTO(Integer id, String title, String salary, String contact, String jobTags, String description, String jobDetail, Date datePost, Date closedDate, String workingTime, Boolean hidden, List<Location> locations, Integer priority) {
        this.id = id;
        this.title = title;
        this.salary = salary;
        this.contact = contact;
        this.jobTags = jobTags;
        this.description = description;
        this.jobDetail = jobDetail;
        this.datePost = datePost;
        this.closedDate = closedDate;
        this.workingTime = workingTime;
        this.hidden = hidden;
        this.locations = locations;
        this.priority = priority;
    }

    private String title;


    private String salary;

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

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    private String contact;


    private String jobTags;


    private String description;


    private String jobDetail;
    private Date datePost;

    private Date closedDate;


    private String workingTime;

    private Boolean hidden;

    private List<Location> locations = new ArrayList<>();

    private Integer priority;


    public JobsDTO() {
    }

}
