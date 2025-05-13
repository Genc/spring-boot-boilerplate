package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.dto.PostJobDTO;
import com.hiringglobal.mobile.model.Job;
import com.hiringglobal.mobile.model.RawTextJob;
import com.hiringglobal.mobile.repository.ICategoryRepository;
import com.hiringglobal.mobile.repository.ILocationRepository;
import com.hiringglobal.mobile.repository.IRawTextJobRepo;
import com.hiringglobal.mobile.repository.IRecruiterRepository;
import com.hiringglobal.mobile.repository.JobRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService implements IJobService {

	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private IRecruiterRepository recruiterRepository;
	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private ILocationRepository locationRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Job> searchJobs(String keyword, Integer categoryId, Integer locationId) {
//        if (keyword == "" && categoryId == null && locationId == null) {
//            return Collections.emptyList(); // Trả về danh sách rỗng khi không có tham số tìm kiếm
//        }
		return jobRepository.searchJobs(keyword, categoryId, locationId);
	}

	public Job getJobById(Integer jobId) {
		// Sử dụng JobRepository để lấy thông tin công việc dựa trên jobId
		System.out.println(jobRepository.findById(jobId).orElse(null).getRecruiter().getFullname());
		// Trả về null nếu không tìm thấy công việc
		return jobRepository.findById(jobId).orElse(null);
	}

	@Override
	public List<Job> getTop3NewestJobsByRecruiter(Integer recruiterId) {
		return jobRepository.findTop3NewestJobsByRecruiter(recruiterId);
	}

	@Override
	public PostJobDTO getJobByIdAndRecruter(Integer jobId, Integer userId) {
		// Sử dụng JobRepository để lấy thông tin công việc dựa trên jobId

		// Trả về null nếu không tìm thấy công việc
		return mapper.map(jobRepository.findByIdAndRecruiterId(jobId, recruiterRepository.findByUserId(userId).getId())
				.orElse(null), PostJobDTO.class);
	}
	
	public void updateJob(PostJobDTO jobDTO,Integer userId) {
		Job job= jobRepository.findByIdAndRecruiterId(jobDTO.getId(), recruiterRepository.findByUserId(userId).getId()).get() ;
		job.setCategory(categoryRepository.findById(jobDTO.getCategory().getId()).orElse(null));
		job.setLocations(locationRepository.findAllById(jobDTO.getLocationIds()).stream().collect(Collectors.toSet()));
		job.setDatePost(jobDTO.getClosedDate());
		job.setContact(jobDTO.getContact());
		job.setDescription(jobDTO.getDescription());
		job.setHidden(jobDTO.getHidden());
		job.setIsAccepted(null);
		job.setJobDetail(jobDTO.getJobDetail());
		job.setJobTags(jobDTO.getJobTags());
		job.setSalary(jobDTO.getSalary());
		job.setTitle(jobDTO.getTitle());
		job.setWorkingTime(jobDTO.getWorkingTime());
		
		job = jobRepository.save(job);
	}
}
