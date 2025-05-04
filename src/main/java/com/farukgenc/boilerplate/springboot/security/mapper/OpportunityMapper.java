package com.farukgenc.boilerplate.springboot.security.mapper;

import com.farukgenc.boilerplate.springboot.model.Opportunity;
import com.farukgenc.boilerplate.springboot.model.Organization;
import com.farukgenc.boilerplate.springboot.security.dto.CreateOpportunityRequest;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationOrganizationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OpportunityMapper {
    OpportunityMapper MAPPER = Mappers.getMapper(OpportunityMapper.class);

    @Mapping(target = "createdBy", constant = "Sample")
    Opportunity toOpportunity(CreateOpportunityRequest request);
}
