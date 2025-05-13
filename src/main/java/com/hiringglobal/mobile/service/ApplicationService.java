package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.dto.PostJobDTO;
import com.hiringglobal.mobile.model.Applicant;
import com.hiringglobal.mobile.model.Application;
import com.hiringglobal.mobile.model.Job;
import com.hiringglobal.mobile.model.Recruiter;
import com.hiringglobal.mobile.repository.ApplicationRepository;
import com.hiringglobal.mobile.repository.IJobRepository;
import com.hiringglobal.mobile.repository.IRecruiterRepository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements IApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private IRecruiterRepository recruiterRepository;

	@Autowired
	private IJobRepository jobRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Application createApplication(String letter, String linkCV, Applicant applicant, Job job) {
		Application application = new Application();
		application.setLetter(letter);
		application.setLinkCV(linkCV);
		application.setApplicant(applicant);
		application.setJob(job);
		return applicationRepository.save(application);
	}

	@Override
	public List<Application> filterByRecruiterAndStatus(Integer userId, String status) {
		Recruiter recruiter = recruiterRepository.findByUserId(userId);
		if (status == null || status.equals("all")) {
			return applicationRepository.findAllByJobIdIn(jobRepository.findJobByRecruiterId(recruiter.getId()));
		} else {
			return applicationRepository.findAllByJobIdInAndIsApproved(
					jobRepository.findJobByRecruiterId(recruiter.getId()), Boolean.parseBoolean(status));

		}
	}

	@Override
	public PostJobDTO getAllByRecruiterAndJob(Integer userId, Integer jobId) {
		Recruiter recruiter = recruiterRepository.findByUserId(userId);
		Job job = jobRepository.findByRecruiterIdAndId(recruiter.getId(), jobId).orElseThrow();
		PostJobDTO jobDTO = modelMapper.map(job, PostJobDTO.class);
		jobDTO.setApplications(applicationRepository.findAllByJobId(job.getId()));
		return jobDTO;
	}

	@Override
	public void updateStatusJob(Integer jobId, Integer userId, Boolean status) {
		Recruiter recruiter = recruiterRepository.findByUserId(userId);
		Job job = jobRepository.findByRecruiterIdAndId(recruiter.getId(), jobId).orElseThrow();
		job.setHidden(status);
		jobRepository.save(job);
	}

	@Override
	public void deleteJobByRecruiter(Integer jobId, Integer userId) {
		Recruiter recruiter = recruiterRepository.findByUserId(userId);
		Job job = jobRepository.findByRecruiterIdAndId(recruiter.getId(), jobId).orElseThrow();
		jobRepository.deleteById(job.getId());
	}

	@Override
	public void updateStatusApplication(Integer applicationId, Integer userId, Boolean status, Integer jobId) {
		Recruiter recruiter = recruiterRepository.findByUserId(userId);
		Job job = jobRepository.findByRecruiterIdAndId(recruiter.getId(), jobId).orElseThrow();
		Application application = applicationRepository.findAllByJobIdAndId(job.getId(), applicationId).orElseThrow();
		application.setIsApproved(status);
		applicationRepository.save(application);
	}

	@Override
	public Application viewByApplicant(Integer applicantId, Integer applicationId) {
		return applicationRepository.findByIdAndApplicantId(applicationId, applicantId).orElseThrow();
	}

	@Override
	public Application viewByRecruiter(Integer userId, Integer applicationId) {
		Recruiter recruiter=recruiterRepository.findByUserId(userId);
		return applicationRepository.findByIdAndJobIdIn(applicationId, jobRepository.findJobByRecruiterId(recruiter.getId())).orElseThrow();
	}

}
