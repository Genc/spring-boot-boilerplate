package com.hiringglobal.mobile.repository;


import com.hiringglobal.mobile.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.model.Company;

import java.util.List;

public interface ICompanyRepository extends JpaRepository<Company, Integer>{

    Company findByRecruiterUserId(Integer userId);
    List<Company> searchCompaniesByNameLike(String keyword);
}



