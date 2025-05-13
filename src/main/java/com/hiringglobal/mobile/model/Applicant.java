package com.hiringglobal.mobile.model;

import java.util.Set;

import com.hiringglobal.mobile.constants.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "applicants")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 255)
	private String fullname;

	@Column(length = 255, nullable = false)
	private String email;

	@Column(length = 255)
	private String avatar;

	private Integer age;

	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
	private Resume resume;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany
	@JoinTable(name = "bookmarked", joinColumns = @JoinColumn(name = "applicant_id"), inverseJoinColumns = @JoinColumn(name = "job_id"))
	private Set<Job> savedJobs;

	public Applicant() {

	}

	public Applicant(Integer id, String fullname, String email, String avatar, Integer age, Gender gender, User user,
			Resume resume, Category category, Set<Job> savedJobs) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.avatar = avatar;
		this.age = age;
		this.gender = gender;
		this.user = user;
		this.resume = resume;
		this.category = category;
		this.savedJobs = savedJobs;
	}


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Set<Job> getSavedJobs() {
		return savedJobs;
	}

	public void setSavedJobs(Set<Job> savedJobs) {
		this.savedJobs = savedJobs;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void addSavedJob(Job job) {
		savedJobs.add(job);
	}

	public void removeSavedJob(Job job) {
		savedJobs.remove(job);
	}
}
