package com.hiringglobal.mobile.dto;

public class AccountDTO {
	
	private String username;
	
	private String password;
	
	private Boolean locked;
	
	private String name;
	
	public AccountDTO() {

	}

	public AccountDTO(String username, String password, Boolean locked, String name) {
		this.username = username;
		this.password = password;
		this.locked = locked;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
