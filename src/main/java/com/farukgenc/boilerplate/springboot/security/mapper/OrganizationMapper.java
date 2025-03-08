package com.farukgenc.boilerplate.springboot.security.mapper;

import com.farukgenc.boilerplate.springboot.model.Organization;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationOrganizationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {
    OrganizationMapper MAPPER = Mappers.getMapper(OrganizationMapper.class);

    @Mapping(target = "createdBy", constant = "Sample")
    Organization toOrganization(RegistrationOrganizationRequest request);
}
