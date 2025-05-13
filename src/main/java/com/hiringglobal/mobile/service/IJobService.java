package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.dto.PostJobDTO;
import com.hiringglobal.mobile.model.Job;

import java.util.List;

public interface IJobService {
    List<Job> searchJobs(String keyword, Integer categoryId, Integer locationId);

    List<Job> getTop3NewestJobsByRecruiter(Integer recruiterId);
    Job getJobById(Integer id);

	PostJobDTO getJobByIdAndRecruter(Integer jobId, Integer userId);
}
