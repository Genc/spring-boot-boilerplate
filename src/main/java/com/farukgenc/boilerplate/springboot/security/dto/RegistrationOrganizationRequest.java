package com.farukgenc.boilerplate.springboot.security.dto;

import com.farukgenc.boilerplate.springboot.model.enums.OrganizationType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegistrationOrganizationRequest {
    @NotEmpty(message = "not empty")
    private String name;

    @NotEmpty(message = "not empty")
    private String email;

    @NotEmpty(message = "not empty")
    private String password;

    @NotEmpty(message = "not empty")
    private String confirmPassword;

    @NotEmpty(message = "not empty")
    private String phoneNumber;

    private OrganizationType type;

    private String otherType;

    private String missionStatement;

    @NotEmpty(message = "not empty")
    private String address;

    @NotEmpty(message = "not empty")
    private String city;

    @NotEmpty(message = "not empty")
    private String stateProvince;

    @NotEmpty(message = "not empty")
    private String zipPostalCode;

    @NotEmpty(message = "not empty")
    private String country;

}
