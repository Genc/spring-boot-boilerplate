package com.hiringglobal.mobile.repository;

import com.hiringglobal.mobile.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumesRepository extends JpaRepository<Resume, Integer> {
    Resume findByApplicantUserId(Integer userId);

}