package com.hiringglobal.mobile.repository;
import com.hiringglobal.mobile.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Để sử dụng các truy vấn tùy chỉnh nếu cần thiết
}