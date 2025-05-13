package com.hiringglobal.mobile.repository;
import com.hiringglobal.mobile.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfFileRepository extends JpaRepository<Resume, Integer> {
    // You can add custom query methods here if needed
}