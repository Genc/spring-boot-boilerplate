package com.hiringglobal.mobile.dto;

import com.hiringglobal.mobile.model.Role;
import jakarta.persistence.*;

import java.util.Set;

public class User {
	private Integer id;

	private String username;

	private String password;

	private Boolean locked = false;

	private String name;

	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public User(Integer id, String username, String password, Boolean locked, String name, Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.locked = locked;
		this.name = name;
		this.roles = roles;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
