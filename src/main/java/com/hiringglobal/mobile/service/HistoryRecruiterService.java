package com.hiringglobal.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiringglobal.mobile.model.OrderHitoryRecruiter;
import com.hiringglobal.mobile.repository.IOrderRecruiterRepo;

@Service
public class HistoryRecruiterService implements IOrderHistoryRecruiter{
	@Autowired
	private IOrderRecruiterRepo orderRecruiterRepo;
	
	@Override
	public List<OrderHitoryRecruiter> getHistoryRecruiter(Integer id) {
		return orderRecruiterRepo.findByRecruiterUserId(id);
	}

}
