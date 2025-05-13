package com.hiringglobal.mobile.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hiringglobal.mobile.dto.ApplicantDTO;
import com.hiringglobal.mobile.constants.Gender;
import com.hiringglobal.mobile.model.Applicant;

public interface ICandidateService {
	Page<ApplicantDTO> filter(String location,Integer categoryId,Gender gender,Pageable pageable);
	Applicant getApplicant(Integer id);
}
