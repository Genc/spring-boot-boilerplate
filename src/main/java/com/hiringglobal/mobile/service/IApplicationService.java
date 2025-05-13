package com.hiringglobal.mobile.service;

import java.util.List;

import com.hiringglobal.mobile.dto.PostJobDTO;
import com.hiringglobal.mobile.model.Applicant;
import com.hiringglobal.mobile.model.Application;
import com.hiringglobal.mobile.model.Job;

public interface IApplicationService {
	List<Application> filterByRecruiterAndStatus(Integer userId,String status);
	PostJobDTO getAllByRecruiterAndJob(Integer userId,Integer jobId);
	Application createApplication(String letter, String linkCV, Applicant applicant, Job job);
	void updateStatusJob(Integer JobId, Integer userID, Boolean status);
	void deleteJobByRecruiter(Integer jobId,Integer userId);
	void updateStatusApplication(Integer applicationId, Integer userId, Boolean status, Integer jobId);
	Application viewByApplicant(Integer userId,Integer applicationId);
	Application viewByRecruiter(Integer userId,Integer applicationId);
}
