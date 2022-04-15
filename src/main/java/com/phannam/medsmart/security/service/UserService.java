package com.phannam.medsmart.security.service;

import com.phannam.medsmart.model.User;
import com.phannam.medsmart.security.dto.AuthenticatedUserDto;
import com.phannam.medsmart.security.dto.RegistrationRequest;
import com.phannam.medsmart.security.dto.RegistrationResponse;

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
