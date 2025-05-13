package com.hiringglobal.mobile.service;

import java.util.List;

import com.hiringglobal.mobile.config.RenderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiringglobal.mobile.model.VipRecruiter;
import com.hiringglobal.mobile.repository.IVipRecruiterRepository;

@Service
public class VipRecruiterService implements IVipRecruiterService{

	private IVipRecruiterRepository vipRecruiterRepository;

	private ValidateService validateService;

	public VipRecruiterService(IVipRecruiterRepository vipRecruiterRepository, ValidateService validateService) {
		this.vipRecruiterRepository = vipRecruiterRepository;
		this.validateService = validateService;
	}

	@Override
	public List<VipRecruiter> findAll() {
		return vipRecruiterRepository.findALLBySupported(true);
	}

	@Override
	public VipRecruiter findById(Integer id) {
		return vipRecruiterRepository.findById(id).orElse(null);
	}

	@Override
	public void update(VipRecruiter t) {
		VipRecruiter packages = vipRecruiterRepository.findByName(t.getName());
		boolean isValid = validateService.validateString(t.getName());
		if(isValid){
				vipRecruiterRepository.save(t);
			}else{
				throw new RenderException("Package name already exits or not must be null !");
			}
		}


	@Override
	public void remove(Integer id) {
		vipRecruiterRepository.deleteById(id);
	}

}
