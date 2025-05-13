package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Applicant;
import com.hiringglobal.mobile.model.Application;
import com.hiringglobal.mobile.model.Job;
import com.hiringglobal.mobile.dto.PostJobDTO;
import com.hiringglobal.mobile.model.Recruiter;
import com.hiringglobal.mobile.repository.ApplicationRepository;
import com.hiringglobal.mobile.repository.ICategoryRepository;
import com.hiringglobal.mobile.repository.IJobRepository;
import com.hiringglobal.mobile.repository.ILocationRepository;
import com.hiringglobal.mobile.repository.IRawTextJobRepo;
import com.hiringglobal.mobile.repository.IRecruiterRepository;
import com.hiringglobal.mobile.repository.JobRepository;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostJobService implements IPostJobService {
	@Autowired
	private IRecruiterRepository recruiterRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private JobRepository postJobRepository;

	@Autowired
	private ILocationRepository locationRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IJobRepository jobRepository;

	@Override
	public PostJobDTO getPostJob(Integer id) {
		Job job = postJobRepository.findById(id).orElse(null);
		PostJobDTO postJobDTO = new PostJobDTO();
		if (job != null) {
			postJobDTO.setTitle(postJobDTO.getTitle());
			postJobDTO.setDescription(postJobDTO.getDescription());
			postJobDTO.setJobDetail(postJobDTO.getJobDetail());
			postJobDTO.setJobTags(postJobDTO.getJobTags());
			postJobDTO.setSalary(postJobDTO.getSalary());
			postJobDTO.setWorkingTime(postJobDTO.getWorkingTime());
			postJobDTO.setDatePost(postJobDTO.getDatePost());
			postJobDTO.setClosedDate(postJobDTO.getClosedDate());
			postJobDTO.setAddress(postJobDTO.getAddress());
			postJobDTO.setFullname(postJobDTO.getFullname());
			postJobDTO.setEmail(postJobDTO.getEmail());
			postJobDTO.setContact(postJobDTO.getContact());
		}
		return postJobDTO;
	}
	
	@Transactional
	@Override
	public PostJobDTO postJobDTO(Integer userId, PostJobDTO postJobDTO) {
		Recruiter recruiter = recruiterRepository.findByUserId(userId);
		if (checkPostJob(recruiter)) {
			Job job = new Job();
			job.setTitle(postJobDTO.getTitle());
			job.setDescription(postJobDTO.getDescription());
			job.setJobDetail(postJobDTO.getJobDetail());
			job.setJobTags(postJobDTO.getJobTags());
			job.setSalary(postJobDTO.getSalary());
			job.setWorkingTime(postJobDTO.getWorkingTime());
			job.setContact(postJobDTO.getContact());
			job.setDatePost(LocalDate.now());
			job.setClosedDate(postJobDTO.getClosedDate());
			job.setIsAccepted(null);
			job.setRecruiter(recruiter);
			job.setCategory(categoryRepository.findById(postJobDTO.getCategory().getId()).orElseThrow());
			job.setHidden(postJobDTO.getHidden());
			job.setLocations(
					locationRepository.findAllById(postJobDTO.getLocationIds()).stream().collect(Collectors.toSet()));
			job = jobRepository.save(job);
			
			return modelMapper.map(job, PostJobDTO.class);
		}
		
		
		return postJobDTO;
	}

	@Override
	public List<PostJobDTO> findAllByRecruiter(Integer userId) {
		return postJobRepository.findAllByRecruiterId(recruiterRepository.findByUserId(userId).getId()).stream()
				.map(job -> {
					PostJobDTO dto = modelMapper.map(job, PostJobDTO.class);
					System.out.println(dto.getHidden());
					dto.setNumberApplications(applicationRepository.countByJobId(job.getId()));
					return dto;
				}).collect(Collectors.toList());

	}

	@Override
	public Boolean checkPostJob(Recruiter recruiter) {
		Long numPost = postJobRepository.countByRecruiterIdAndHiddenAndIsAccepted(recruiter.getId(), true, true);
		return numPost < recruiter.getUpgradedRecruiter().getVipRecruiter().getLimitedPosts()
				&& recruiter.getUpgradedRecruiter().getExpired().isAfter(LocalDateTime.now());
	}

	@Override
	public Boolean checkPostApplicationsJob(Integer jobId, Applicant applicant) {
		Integer numApply = applicationRepository.countByJobId(jobId);
		Recruiter recruiter = jobRepository.findById(jobId).orElseThrow().getRecruiter();

		return numApply < recruiter.getUpgradedRecruiter().getVipRecruiter().getLimitedApplications()
				&& recruiter.getUpgradedRecruiter().getExpired().isAfter(LocalDateTime.now());
	}

	@Override
	public Boolean checkApply(Job job, Applicant applicant) {
		Optional<Application> application = applicationRepository.findTop1ByJobIdAndApplicantIdOrderByApplyDateDesc(job.getId(), applicant.getId());
		return application.isEmpty() || !application.orElse(null).getApplyDate().toLocalDate().equals(LocalDate.now());
	}
}
