package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Applicant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiringglobal.mobile.dto.CompanyDTO;
import com.hiringglobal.mobile.model.Company;
import com.hiringglobal.mobile.model.Recruiter;
import com.hiringglobal.mobile.repository.ICompanyRepository;
import com.hiringglobal.mobile.repository.IRecruiterRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private ICompanyRepository companyRepository;

	@Autowired
	private IRecruiterRepository recruiterRepository;

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private FirebaseStorageService firebaseStorageService;

	@Override
	public void update(CompanyDTO t) {
		Company company = mapper.map(t, Company.class);
		Recruiter recruiter=recruiterRepository.findByUserId(t.getUserId());
		if(recruiter.getCompany()!=null) {
			recruiter.getCompany().setWebsite(company.getWebsite());
			recruiter.getCompany().setAddress(company.getAddress());
			recruiter.getCompany().setContact(company.getContact());
			recruiter.getCompany().setEmail(company.getEmail());
			recruiter.getCompany().setIntroduction(company.getIntroduction());
			recruiter.getCompany().setName(company.getName());
			companyRepository.save(recruiter.getCompany());
		}else {
			company.setRecruiter(recruiter);
			companyRepository.save(company);
		}

	}
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	public Company getCompanyById(Integer companyId) {
		return companyRepository.findById(companyId).orElse(null);
	}

}