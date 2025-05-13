package com.hiringglobal.mobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hiringglobal.mobile.model.VipRecruiter;
import org.springframework.data.jpa.repository.Query;


public interface IVipRecruiterRepository extends JpaRepository<VipRecruiter, Integer>{
	Optional<VipRecruiter> findByIdAndSupported(Integer id, Boolean supported);
	Optional<VipRecruiter> findTop1BySupportedOrderByPricingAsc(Boolean supported);
	List<VipRecruiter> findALLBySupported(Boolean supported);

	@Query("SELECT SUM(order.vipRecruiter.pricing) FROM UpgradedRecruiter order")
	double calculateTotalRevenue();

	VipRecruiter findByName(String name);
}
