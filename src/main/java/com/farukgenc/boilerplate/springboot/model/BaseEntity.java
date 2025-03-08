package com.farukgenc.boilerplate.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Length(max = 50)
    @Column(nullable = false)
    private String createdBy;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    private LocalDateTime createdDt;

    @Length(max = 50)
    private String updatedBy;

    @UpdateTimestamp
    @EqualsAndHashCode.Exclude
    private LocalDateTime updatedDt;
}