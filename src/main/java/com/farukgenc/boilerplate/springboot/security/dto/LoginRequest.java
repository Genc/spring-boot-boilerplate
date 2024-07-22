package com.farukgenc.boilerplate.springboot.security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

	@NotEmpty(message = "{login_username_not_empty}")
	private String username;

	@NotEmpty(message = "{login_password_not_empty}")
	private String password;

}
