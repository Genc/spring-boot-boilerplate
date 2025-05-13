package com.hiringglobal.mobile.service;

import java.util.List;

import com.hiringglobal.mobile.dto.PostJobDTO;
import com.hiringglobal.mobile.model.Applicant;
import com.hiringglobal.mobile.model.Job;
import com.hiringglobal.mobile.model.Recruiter;

public interface IPostJobService {
    PostJobDTO getPostJob(Integer id);

    PostJobDTO postJobDTO(Integer userId, PostJobDTO postJobDTO);
    
    List<PostJobDTO> findAllByRecruiter(Integer userId);
    
    Boolean checkPostJob(Recruiter recruiter);

	Boolean checkPostApplicationsJob(Integer jobId, Applicant applicant);

	Boolean checkApply(Job job, Applicant applicant);
}
