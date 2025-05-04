package com.farukgenc.boilerplate.springboot.security.service;

import com.farukgenc.boilerplate.springboot.model.Opportunity;
import com.farukgenc.boilerplate.springboot.repository.OpportunityRepository;
import com.farukgenc.boilerplate.springboot.security.dto.CreateOpportunityRequest;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationResponse;
import com.farukgenc.boilerplate.springboot.security.mapper.OpportunityMapper;
import com.farukgenc.boilerplate.springboot.service.OpportunityValidationService;
import com.farukgenc.boilerplate.springboot.utils.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpportunityServiceImpl implements OpportunityService {
    private static final String REGISTRATION_SUCCESSFUL = "registration_successful";


    private final OpportunityValidationService opportunityValidationService;
    private final OpportunityRepository opportunityRepository;
    private final GeneralMessageAccessor generalMessageAccessor;

    public RegistrationResponse createNewOpportunity(CreateOpportunityRequest request) {
        opportunityValidationService.validateOrganization(UUID.fromString(request.getOrganizationId()));

        final Opportunity opportunity = OpportunityMapper.MAPPER.toOpportunity(request);
        opportunityRepository.save(opportunity);

        final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, request.getTitle());

        log.info("{} registered successful!", request.getTitle());

        return new RegistrationResponse(registrationSuccessMessage);
    }
}
