package com.hiringglobal.mobile.service;

import java.util.List;

import com.hiringglobal.mobile.model.OrderHitoryRecruiter;

public interface IOrderHistoryRecruiter {
	List<OrderHitoryRecruiter> getHistoryRecruiter(Integer id);
}
