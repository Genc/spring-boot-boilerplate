package com.hiringglobal.mobile.thien.service;

import com.hiringglobal.mobile.model.Job;

import java.util.List;

public interface IJobService {
    List<Job> findAll();

    Job findById(int theId);

    void acceptJob(int idJob, boolean accept);

    void save(Job job);

    void deleteById(int theId);
}
