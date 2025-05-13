package com.hiringglobal.mobile.dto;

public class RecruiterDTO {
	private Integer id;
	private String fullname;
	private String email;
	private String phone;
	private Integer userId;
	private AccountDTO account;

	public RecruiterDTO() {

	}

	public RecruiterDTO(Integer id, String fullname, String email, String phone, Integer userId, AccountDTO account) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.userId = userId;
		this.account = account;
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


}
