package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.UpgradedRecruiter;

public interface IUpgradeRecruiterService {
	UpgradedRecruiter registerVipRecruiterPackage(Integer userId, Integer vipId, String transNo, Integer amount) throws Exception;
}
