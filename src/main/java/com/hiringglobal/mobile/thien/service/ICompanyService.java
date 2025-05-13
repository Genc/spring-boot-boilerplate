package com.hiringglobal.mobile.thien.service;

import com.hiringglobal.mobile.model.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> findAll();

    Company findById(int theId);

    void save(Company company);

    void deleteById(int theId);

}
