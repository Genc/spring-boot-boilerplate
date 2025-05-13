package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Recruiter;
import com.hiringglobal.mobile.repository.IRecruiterRepository;
import com.hiringglobal.mobile.thien.service.IRecruiterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterServiceImpl implements IRecruiterService {

    private IRecruiterRepository recruiterRepository;


    public RecruiterServiceImpl(IRecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public List<Recruiter> findAll() {
        return recruiterRepository.findAll();
    }

    @Override
    public Recruiter findById(int theId) {
        Optional<Recruiter> result = recruiterRepository.findById(theId);

        Recruiter recruiter = null;

        if(result.isPresent()) {
            recruiter = result.get();
        }else{
            throw new RuntimeException("Id recruiter not found ??? -> " + theId );
        }

        return recruiter;
    }

    @Override
    public void save(Recruiter recruiter) {
        recruiterRepository.save(recruiter);
    }

    @Override
    public void deleteById(int theId) {
        recruiterRepository.deleteById(theId);
    }
}
