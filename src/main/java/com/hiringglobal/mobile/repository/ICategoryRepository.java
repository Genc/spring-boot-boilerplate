package com.hiringglobal.mobile.repository;

import com.hiringglobal.mobile.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Category findByNameAndNameNotNull(String name);
}
