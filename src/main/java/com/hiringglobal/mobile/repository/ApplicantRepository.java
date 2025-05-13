package com.hiringglobal.mobile.repository;

import com.hiringglobal.mobile.model.Applicant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
	Optional<Applicant> findByUserId(Integer userId);

}
