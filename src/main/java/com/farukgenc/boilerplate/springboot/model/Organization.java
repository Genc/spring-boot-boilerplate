package com.farukgenc.boilerplate.springboot.model;

import com.farukgenc.boilerplate.springboot.model.enums.OrganizationType;
import com.farukgenc.boilerplate.springboot.model.ids.OrganizationId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@Table(name = "Organization")
@Entity
@NoArgsConstructor
// @IdClass(OrganizationId.class)
public class Organization extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

//    @Id
//  private String contactPersonId;

    @Column(length = 255)
    private String name;

    private String email;

    private String password;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private OrganizationType type;

    private String otherType;

    @Column(length = 500)
    private String missionStatement;

    private String address;

    private String city;

    // TODO: SHOULD CHANGE TO ID
    private String stateProvince;

    private String zipPostalCode;

    // TODO: SHOULD CHANGE TO ID
    private String country;
}
