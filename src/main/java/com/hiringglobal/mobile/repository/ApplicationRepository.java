package com.hiringglobal.mobile.repository;
import com.hiringglobal.mobile.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByApplicantId(Integer applicantId);
    Integer countByJobId(Integer jobId);
    List<Application> findAllByJobIdInAndIsApproved(List<Integer> jobIds,Boolean status);
    List<Application> findAllByJobId(Integer jobId);
    Optional<Application> findAllByJobIdAndId(Integer jobId,Integer id);
	List<Application> findAllByJobIdIn(List<Integer> findJobByRecruiterId);
	Optional<Application> findByIdAndApplicantId(Integer id,Integer applicantId);
	Optional<Application> findByIdAndJobIdIn(Integer id,List<Integer> jobIds);
	
	Optional<Application> findTop1ByJobIdAndApplicantIdOrderByApplyDateDesc(Integer jobId, Integer applicantId);
}
