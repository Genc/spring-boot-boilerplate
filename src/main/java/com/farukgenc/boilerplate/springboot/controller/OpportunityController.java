package com.farukgenc.boilerplate.springboot.controller;


import com.farukgenc.boilerplate.springboot.security.dto.CreateOpportunityRequest;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationOrganizationRequest;
import com.farukgenc.boilerplate.springboot.security.dto.RegistrationResponse;
import com.farukgenc.boilerplate.springboot.security.service.OpportunityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register/opportunity") // temporary to skip authorization
public class OpportunityController {
    private final OpportunityService opportunityService;

    @PostMapping
    public ResponseEntity<RegistrationResponse> createNewOpportunity(@Valid @RequestBody CreateOpportunityRequest request){

        final RegistrationResponse createOpportunityResponse = opportunityService.createNewOpportunity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createOpportunityResponse);

    }
}
