package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.dto.DetailRecruiterDTO;
import com.hiringglobal.mobile.dto.RecruiterDTO;
import com.hiringglobal.mobile.model.Recruiter;

public interface IRecruiterService {

    DetailRecruiterDTO getDetailRecruiterDTO(Integer userId);


    DetailRecruiterDTO getRecruiterDTO(Integer userId);

    Recruiter registerRecruiter(RecruiterDTO newUser) throws Exception;


    DetailRecruiterDTO getRecruiterProfile(Integer userId);

    void updateRecruiterProfile(Integer userId, DetailRecruiterDTO updateRecruiterProfile);
    
    Recruiter findByUserId(Integer userId);
}
