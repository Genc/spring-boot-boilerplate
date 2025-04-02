package com.hiringglobal.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.model.User;

/**
 * Created on March, 2025
 *
 * @author HungPG
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
