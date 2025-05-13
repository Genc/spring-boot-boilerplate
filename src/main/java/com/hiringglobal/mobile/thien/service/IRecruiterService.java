package com.hiringglobal.mobile.thien.service;

import com.hiringglobal.mobile.model.Recruiter;

import java.util.List;

public interface IRecruiterService {
    List<Recruiter> findAll();

    Recruiter findById(int theId);

    void save(Recruiter recruiter);

    void deleteById(int theId);
}
