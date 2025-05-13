package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Company;
import com.hiringglobal.mobile.repository.ICompanyRepository;
import com.hiringglobal.mobile.thien.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyRepository companyRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int theId) {
        Optional<Company> result = companyRepository.findById(theId);

        Company company = null;

        if(result.isPresent()) {
            company = result.get();
        }else{
            throw new RuntimeException("Id company not found ??? -> " + theId );
        }

        return company;
    }

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void deleteById(int theId) {
        companyRepository.deleteById(theId);
    }
}
