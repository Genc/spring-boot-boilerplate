package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Applicant;
import com.hiringglobal.mobile.repository.IApplicantRepository;
import com.hiringglobal.mobile.thien.service.IApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements IApplicantService {

    @Autowired
    private IApplicantRepository applicantRepository;

    @Override
    public List<Applicant> findAll() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant findById(int theId) {
        Optional<Applicant> result = applicantRepository.findById(theId);

        Applicant applicant = null;

        if(result.isPresent()) {
            applicant = result.get();
        }else{
            throw new RuntimeException("Id category not found ??? -> " + theId );
        }

        return applicant;
    }



    @Override
    public void save(Applicant applicant) {
        applicantRepository.save(applicant);
    }




    @Override
    public void deleteById(int theId) {
        applicantRepository.deleteById(theId);
    }
}
