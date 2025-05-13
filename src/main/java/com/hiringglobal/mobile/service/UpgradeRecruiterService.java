package com.hiringglobal.mobile.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiringglobal.mobile.model.OrderHitoryRecruiter;
import com.hiringglobal.mobile.model.Recruiter;
import com.hiringglobal.mobile.model.UpgradedRecruiter;
import com.hiringglobal.mobile.model.VipRecruiter;
import com.hiringglobal.mobile.repository.IOrderRecruiterRepo;
import com.hiringglobal.mobile.repository.IRecruiterRepository;
import com.hiringglobal.mobile.repository.IVipRecruiterRepository;

import jakarta.transaction.Transactional;

@Service
public class UpgradeRecruiterService implements IUpgradeRecruiterService {

	@Autowired
	private IVipRecruiterRepository vipRecruiterRepository;

	@Autowired
	private IRecruiterRepository recruiterRepository;

	@Autowired
	private IOrderRecruiterRepo orderRecruiterRepo;

	@Transactional
	@Override
	public UpgradedRecruiter registerVipRecruiterPackage(Integer userId, Integer vipId, String transNo, Integer amount) throws Exception {

		VipRecruiter vipRecruiter = vipRecruiterRepository.findByIdAndSupported(vipId, true).orElseThrow();

		if (amount != vipRecruiter.getPricing()*100) {
			throw new Exception("Error money not match to price package. Contact with supporter now!");
		}
		System.out.println(userId);
		Recruiter recruiter = recruiterRepository.findByUserId(userId);

		LocalDateTime now = LocalDateTime.now();

		UpgradedRecruiter newUpgradedRecruiter = new UpgradedRecruiter();
		newUpgradedRecruiter.setStartDate(now);
		newUpgradedRecruiter.setExpired(now.plusDays(vipRecruiter.getDuring()));
		newUpgradedRecruiter.setVipRecruiter(vipRecruiter);
		recruiter.setUpgradedRecruiter(newUpgradedRecruiter);

		OrderHitoryRecruiter hitoryRecruiter = new OrderHitoryRecruiter();
		hitoryRecruiter.setAmount(amount/100);
		hitoryRecruiter.setOrderDate(now);
		hitoryRecruiter.setTitle("Buy package: " + vipRecruiter.getName());
		hitoryRecruiter.setTranNo(transNo);
		hitoryRecruiter.setRecruiter(recruiter);
		orderRecruiterRepo.save(hitoryRecruiter);
		
		return recruiterRepository.save(recruiter).getUpgradedRecruiter();
	}

}
