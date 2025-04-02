package com.hiringglobal.mobile.security.service;

import com.hiringglobal.mobile.model.User;
import com.hiringglobal.mobile.security.dto.AuthenticatedUserDto;
import com.hiringglobal.mobile.security.dto.RegistrationRequest;
import com.hiringglobal.mobile.security.dto.RegistrationResponse;

/**
 * Created on March, 2025
 *
 * @author HungPG
 */
public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
