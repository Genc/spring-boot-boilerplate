package com.hiringglobal.mobile.dto;

public class Statistics {
    private long totalPosts;

    private long totalApplicants;
    private long totalCompany;
    private long totalLocation;
    private long totalPackages;
    private long totalCategoryJob;
    private double totalRevenue;
    private long todayPosts;

    public Statistics() {
    }

    public Statistics(long totalPosts, long totalApplicants, long totalCompany, long totalLocation, long totalPackages, long totalCategoryJob, double totalRevenue, long todayPosts) {
        this.totalPosts = totalPosts;
        this.totalApplicants = totalApplicants;
        this.totalCompany = totalCompany;
        this.totalLocation = totalLocation;
        this.totalPackages = totalPackages;
        this.totalCategoryJob = totalCategoryJob;
        this.totalRevenue = totalRevenue;
        this.todayPosts = todayPosts;
    }

    public long getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(long totalPosts) {
        this.totalPosts = totalPosts;
    }

    public long getTotalApplicants() {
        return totalApplicants;
    }

    public void setTotalApplicants(long totalApplicants) {
        this.totalApplicants = totalApplicants;
    }

    public long getTotalCompany() {
        return totalCompany;
    }

    public void setTotalCompany(long totalCompany) {
        this.totalCompany = totalCompany;
    }

    public long getTotalLocation() {
        return totalLocation;
    }

    public void setTotalLocation(long totalLocation) {
        this.totalLocation = totalLocation;
    }

    public long getTotalPackages() {
        return totalPackages;
    }

    public void setTotalPackages(long totalPackages) {
        this.totalPackages = totalPackages;
    }

    public long getTotalCategoryJob() {
        return totalCategoryJob;
    }

    public void setTotalCategoryJob(long totalCategoryJob) {
        this.totalCategoryJob = totalCategoryJob;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public long getTodayPosts() {
        return todayPosts;
    }

    public void setTodayPosts(long todayPosts) {
        this.todayPosts = todayPosts;
    }
}
