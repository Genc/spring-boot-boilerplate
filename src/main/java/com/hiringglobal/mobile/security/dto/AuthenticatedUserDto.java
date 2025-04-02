package com.hiringglobal.mobile.security.dto;

import com.hiringglobal.mobile.model.UserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on March, 2025
 *
 * @author HungPG
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

	private String name;

	private String username;

	private String password;

	private UserRole userRole;

}
