package com.farukgenc.booilerplate.springboot.security.service;

import com.farukgenc.booilerplate.springboot.model.User;
import com.farukgenc.booilerplate.springboot.security.dto.AuthenticatedUserDto;
import com.farukgenc.booilerplate.springboot.security.dto.RegistrationRequest;
import com.farukgenc.booilerplate.springboot.security.dto.RegistrationResponse;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
