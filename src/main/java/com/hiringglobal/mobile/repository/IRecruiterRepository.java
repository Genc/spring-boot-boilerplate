package com.hiringglobal.mobile.repository;


import java.time.LocalDateTime;
import java.util.List;

import com.hiringglobal.mobile.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.model.Recruiter;

public interface IRecruiterRepository extends JpaRepository<Recruiter, Integer> {

	Recruiter findByUserId(Integer userId);
	List<Recruiter> findByCompany(Company company);
	List<Recruiter> findByUpgradedRecruiterExpiredGreaterThanOrderByUpgradedRecruiterVipRecruiterPriorityAsc(LocalDateTime expired);
}
