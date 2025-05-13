package com.hiringglobal.mobile.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.constants.Gender;
import com.hiringglobal.mobile.model.Applicant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IApplicantRepository extends JpaRepository<Applicant, Integer> {

	@Query("SELECT a FROM Applicant a JOIN a.user u JOIN u.roles r WHERE r.id = 1")
	List<Applicant> findApplicantsByRoleId();

	Optional<Applicant> findByUserId(Integer userId);

	@Query("Select a From Applicant a "
			+ "Where (:location = '' Or a.resume.address Like %:location%) "
			+ "And (:gender is null Or a.gender=:gender) "
			+ "And (:categoryId is null Or a.category.id=:categoryId)")
	Page<Applicant> filter(@Param("location") String location, @Param("gender") Gender gender,
			@Param("categoryId") Integer categoryId, Pageable pageable);
}
