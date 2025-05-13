package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.dto.*;
import com.hiringglobal.mobile.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private IApplicantRepository applicantRepository;

    @Autowired
    private IJobRepository jobRepository;

    @Autowired
    private ICompanyRepository companyRepository;

    @Autowired
    private ILocationRepository locationRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IPackageRepository packageRepository;
    @Override
    public Statistics calculateStatistics() {
        Statistics statistics = new Statistics();
        statistics.setTotalPosts(jobRepository.count());
        statistics.setTotalApplicants(applicantRepository.count());
        statistics.setTotalCompany(companyRepository.count());
        statistics.setTotalLocation(locationRepository.count());
        statistics.setTotalCategoryJob(categoryRepository.count());
        statistics.setTotalPackages(packageRepository.count());
        statistics.setTotalRevenue(packageRepository.calculateTotalRevenue());
        statistics.setTodayPosts(jobRepository.getPostToday());
        return statistics;
    }
}
