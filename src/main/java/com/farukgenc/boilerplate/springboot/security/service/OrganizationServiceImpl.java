package com.farukgenc.boilerplate.springboot.security.service;

import com.farukgenc.boilerplate.springboot.model.Organization;
import com.farukgenc.boilerplate.springboot.repository.OrganizationRepository;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationOrganizationRequest;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationResponse;
import com.farukgenc.boilerplate.springboot.security.mapper.OrganizationMapper;
import com.farukgenc.boilerplate.springboot.service.OrganizationValidationService;
import com.farukgenc.boilerplate.springboot.utils.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

    private final OrganizationValidationService organizationValidationService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final OrganizationRepository organizationRepository;

    private final GeneralMessageAccessor generalMessageAccessor;


    public RegistrationResponse registration(RegistrationOrganizationRequest registrationOrganizationRequest) {
        organizationValidationService.validateOrganization(registrationOrganizationRequest);

        final Organization organization = OrganizationMapper.MAPPER.toOrganization(registrationOrganizationRequest);
        organization.setPassword(bCryptPasswordEncoder.encode(organization.getPassword()));
        organizationRepository.save(organization);

        final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, registrationOrganizationRequest.getName());

        log.info("{} registered successful!", registrationOrganizationRequest.getName());

        return new RegistrationResponse(registrationSuccessMessage);
    }

}
