package com.hiringglobal.mobile.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.hiringglobal.mobile.model.User;
import com.hiringglobal.mobile.security.dto.AuthenticatedUserDto;
import com.hiringglobal.mobile.security.dto.RegistrationRequest;

/**
 * Created on March, 2025
 *
 * @author HungPG
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User convertToUser(RegistrationRequest registrationRequest);

	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	User convertToUser(AuthenticatedUserDto authenticatedUserDto);

}
