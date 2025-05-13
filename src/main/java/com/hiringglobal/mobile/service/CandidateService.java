package com.hiringglobal.mobile.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hiringglobal.mobile.dto.ApplicantDTO;
import com.hiringglobal.mobile.constants.Gender;
import com.hiringglobal.mobile.model.Applicant;
import com.hiringglobal.mobile.repository.IApplicantRepository;

@Service
public class CandidateService implements ICandidateService {
	@Autowired
	private IApplicantRepository applicantRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<ApplicantDTO> filter(String location, Integer categoryId, Gender gender, Pageable pageable) {
		return applicantRepository.filter(location, gender, categoryId, pageable)
				.map(applicant -> modelMapper.map(applicant, ApplicantDTO.class));
	}

	@Override
	public Applicant getApplicant(Integer id) {
		return applicantRepository.findById(id).orElseThrow();
	}

}
