package com.hiringglobal.mobile.repository;

import com.hiringglobal.mobile.model.VipRecruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPackageRepository extends JpaRepository<VipRecruiter, Integer> {
    @Query("SELECT SUM(order.vipRecruiter.pricing) FROM UpgradedRecruiter order")
    double calculateTotalRevenue();
}
