package com.farukgenc.boilerplate.springboot.model;

import com.farukgenc.boilerplate.springboot.model.ids.OpportunityId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@Table(name = "Opportunity")
@Entity
@NoArgsConstructor
@IdClass(OpportunityId.class)
public class Opportunity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Id
    private UUID organizationId;

    private String title;

    private String description;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
