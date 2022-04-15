package com.phannam.medsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phannam.medsmart.model.User;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
