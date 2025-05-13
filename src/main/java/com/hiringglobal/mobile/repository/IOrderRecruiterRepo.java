package com.hiringglobal.mobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.model.OrderHitoryRecruiter;

public interface IOrderRecruiterRepo extends JpaRepository<OrderHitoryRecruiter, Integer>{
	Optional<OrderHitoryRecruiter> findByTranNo(String tranNo);
	List<OrderHitoryRecruiter> findByRecruiterUserId(Integer userId);
}
