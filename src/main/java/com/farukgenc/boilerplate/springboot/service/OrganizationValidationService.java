package com.farukgenc.boilerplate.springboot.service;

import com.farukgenc.boilerplate.springboot.exceptions.RegistrationException;
import com.farukgenc.boilerplate.springboot.repository.OrganizationRepository;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationOrganizationRequest;
import com.farukgenc.boilerplate.springboot.utils.ExceptionMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationValidationService {
    private static final String EMAIL_ALREADY_EXISTS = "organization_email_exists";
    private static final String NAME_ALREADY_EXISTS = "organization_name_exists";

    private final OrganizationRepository organizationRepository;

    private final ExceptionMessageAccessor exceptionMessageAccessor;

    public void validateOrganization(RegistrationOrganizationRequest request){
        final String email = request.getEmail();
        final String name = request.getName();

        checkEmail(email);
        checkUsername(name);
    }

    private void checkEmail(String email){
        final boolean existsByEmail = organizationRepository.existsByEmail(email);

        if (existsByEmail) {
            log.warn("{} is already being used!", email);

            final String existsEmail = exceptionMessageAccessor.getMessage(null, EMAIL_ALREADY_EXISTS);
            throw new RegistrationException(existsEmail);
        }
    }

    private void checkUsername(String username) {

        final boolean existsByUsername = organizationRepository.existsByName(username);

        if (existsByUsername) {

            log.warn("{} is already being used!", username);

            final String existsUsername = exceptionMessageAccessor.getMessage(null, NAME_ALREADY_EXISTS);
            throw new RegistrationException(existsUsername);
        }

    }
}
