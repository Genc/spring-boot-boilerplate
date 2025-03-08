package com.farukgenc.boilerplate.springboot.security.service;

import com.farukgenc.boilerplate.springboot.security.dto.RegistrationOrganizationRequest;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationResponse;

public interface OrganizationService {
    RegistrationResponse registration(RegistrationOrganizationRequest registrationOrganizationRequest);
}
