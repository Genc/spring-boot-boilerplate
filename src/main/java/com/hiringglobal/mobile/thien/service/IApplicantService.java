package com.hiringglobal.mobile.thien.service;

import com.hiringglobal.mobile.model.Applicant;

import java.util.List;

public interface IApplicantService {
    List<Applicant> findAll();

    Applicant findById(int theId);

    void save(Applicant category);

    void deleteById(int theId);
}
