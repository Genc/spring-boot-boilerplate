package com.hiringglobal.mobile.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.model.User;
import com.hiringglobal.mobile.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	VerificationToken findByToken(String token);

	VerificationToken findByUser(User user);
}
