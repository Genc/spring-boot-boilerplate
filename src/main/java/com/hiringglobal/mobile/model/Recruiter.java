package com.hiringglobal.mobile.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "recruiters")
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String fullname;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "upgraded_recruiter_id")
    private UpgradedRecruiter upgradedRecruiter;

    @ManyToMany
    @JoinTable(name = "saved_resumes", joinColumns = @JoinColumn(name = "recruiter_id"), inverseJoinColumns = @JoinColumn(name = "applicant_id"))
    private Set<Applicant> savedResumes;

    @OneToOne(mappedBy = "recruiter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    
	@OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
	private List<Job> job;

	public Recruiter() {

	}

	@PreRemove
	private void preRemove() {
		savedResumes.clear();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UpgradedRecruiter getUpgradedRecruiter() {
		return upgradedRecruiter;
	}

	public void setUpgradedRecruiter(UpgradedRecruiter upgradedRecruiter) {
		this.upgradedRecruiter = upgradedRecruiter;
	}

	public Set<Applicant> getSavedResumes() {
		return savedResumes;
	}

	public void setSavedResumes(Set<Applicant> savedResumes) {
		this.savedResumes = savedResumes;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}


}
