package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Job;
import com.hiringglobal.mobile.model.RawTextJob;
import com.hiringglobal.mobile.repository.IJobRepository;
import com.hiringglobal.mobile.repository.IRawTextJobRepo;
import com.hiringglobal.mobile.thien.service.IJobService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private IJobRepository jobRepository;
    @Autowired
    private IRawTextJobRepo rawTextJobRepo;
    
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }


    @Override
    public Job findById(int theId) {
        Optional<Job> result = jobRepository.findById(theId);
        Job job = null;
        if (result.isPresent()){
            job = result.get();
        }else{
            throw new RuntimeException("Id job not found ??? -> " + theId );
        }
        return job;
    }
    
    @Transactional
    @Override
    public void acceptJob(int idJob, boolean accept) {
//        jobRepository.acceptJob(idJob, accept);
    	
        Job job=jobRepository.findById(idJob).orElseThrow();
        job.setIsAccepted(accept);
        job = jobRepository.save(job);
		RawTextJob rawTextJob = rawTextJobRepo.findByJobId(job.getId()).orElse(new RawTextJob());
		if(rawTextJob != null) {
			rawTextJob.setCategory(job.getCategory().getName());
			rawTextJob.setHidden(job.getHidden());
			rawTextJob.setIsAccepted(job.getIsAccepted());
			// replace all occurrences of one or more HTML tags with optional
			// whitespace inbetween with a single space character
			String strippedText = job.getDescription().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ")+". "
					+job.getJobDetail().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ");
			rawTextJob.setJob_description(strippedText);
			rawTextJob.setPriority(job.getPriority());
			rawTextJob.setClosedDate(job.getClosedDate());
			rawTextJob.setLocations(
				    job.getLocations().stream()
				        .map(loc-> loc.getName()) // Ensure Location has a proper toString() method or use a getter
				        .collect(Collectors.joining(" "))
				);
			rawTextJob.setTitle(job.getTitle());
			rawTextJob.setJob(job);
		}
		rawTextJobRepo.save(rawTextJob);
    }

    @Override
    public void save(Job job) {

    }

    @Override
    public void deleteById(int theId) {
        jobRepository.deleteById(theId);
    }

}
