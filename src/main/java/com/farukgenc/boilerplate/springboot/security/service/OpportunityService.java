package com.farukgenc.boilerplate.springboot.security.service;

import com.farukgenc.boilerplate.springboot.security.dto.CreateOpportunityRequest;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationResponse;

public interface OpportunityService {
    RegistrationResponse createNewOpportunity(CreateOpportunityRequest request);
}
