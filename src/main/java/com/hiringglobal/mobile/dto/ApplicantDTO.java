package com.hiringglobal.mobile.dto;

import com.hiringglobal.mobile.constants.Gender;
import com.hiringglobal.mobile.model.Category;
import com.hiringglobal.mobile.model.Resume;

public class ApplicantDTO {
	private Integer id;
	private String fullname;
	private String email;
	private Integer age;
	private String avatar;
	private Gender gender;
	private Integer userId;
	private AccountDTO account;
	private Resume resume;
	private Category category;

	public ApplicantDTO(Integer id, String fullname, String email, Integer age, Gender gender, Integer userId,
			AccountDTO account) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.userId = userId;
		this.account = account;
	}

	public ApplicantDTO() {

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
