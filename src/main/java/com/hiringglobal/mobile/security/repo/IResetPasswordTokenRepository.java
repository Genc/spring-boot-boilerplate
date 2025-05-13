package com.hiringglobal.mobile.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.model.ResetPasswordToken;

public interface IResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken , Long> {
	ResetPasswordToken findByToken(String token);
	Optional<ResetPasswordToken> findByUserId(Integer userId);
}
