package com.phannam.medsmart.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.phannam.medsmart.model.User;
import com.phannam.medsmart.security.dto.AuthenticatedUserDto;
import com.phannam.medsmart.security.dto.RegistrationRequest;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User convertToUser(RegistrationRequest registrationRequest);

	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	User convertToUser(AuthenticatedUserDto authenticatedUserDto);

}
