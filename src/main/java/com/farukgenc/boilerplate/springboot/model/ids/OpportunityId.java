package com.farukgenc.boilerplate.springboot.model.ids;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OpportunityId implements Serializable {
    @Serial
    private static final long serialVersionUID = -4209093678470383087L;

    private UUID id;
    private UUID organizationId;
}
