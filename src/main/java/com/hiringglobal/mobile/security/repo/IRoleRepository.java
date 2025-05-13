package com.hiringglobal.mobile.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
