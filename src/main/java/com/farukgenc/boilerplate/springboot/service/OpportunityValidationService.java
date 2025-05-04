package com.farukgenc.boilerplate.springboot.service;

import com.farukgenc.boilerplate.springboot.exceptions.RegistrationException;
import com.farukgenc.boilerplate.springboot.repository.OrganizationRepository;
import com.farukgenc.boilerplate.springboot.utils.ExceptionMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpportunityValidationService {
    private static final String ORGANIZATION_NOT_EXIST = "organization_not_exist";

    private final OrganizationRepository organizationRepository;
    private final ExceptionMessageAccessor exceptionMessageAccessor;

    public void validateOrganization(UUID organizationId){
        final boolean existById = organizationRepository.existsById(organizationId);

        if(!existById){
            log.warn("Organization is not exist");

            final String notExistOrganization = exceptionMessageAccessor.getMessage(null, ORGANIZATION_NOT_EXIST);
            throw new RegistrationException(notExistOrganization);
        }
    }
}
