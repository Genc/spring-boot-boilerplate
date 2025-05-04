package com.farukgenc.boilerplate.springboot.repository;

import com.farukgenc.boilerplate.springboot.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OpportunityRepository extends JpaRepository<Opportunity, UUID> {
}