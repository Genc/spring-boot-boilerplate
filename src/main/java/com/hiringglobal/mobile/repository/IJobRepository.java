package com.hiringglobal.mobile.repository;

import com.hiringglobal.mobile.model.Job;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IJobRepository extends JpaRepository<Job, Integer> {

	@Modifying
	@Query("UPDATE Job j SET j.isAccepted = ?2 WHERE j.id = ?1")
	void acceptJob(int idJob, boolean isAccepted);

	@Query("SELECT COUNT(*) FROM Job WHERE DATE(datePost) = CURRENT_DATE")
	int getPostToday();

	@Query("SELECT id FROM Job j WHERE j.recruiter.id=?1")
	List<Integer> findJobByRecruiterId(Integer recruiterId);

	Optional<Job> findByRecruiterIdAndId(Integer recruiterId, Integer jobId);

	Page<Job> findByClosedDateGreaterThanAndIsAcceptedAndHiddenOrderByPriorityAscDatePostDesc(LocalDate expired,
			Boolean accept, Boolean hidden, Pageable pageJobs);

	@Query("SELECT j FROM Job j "
			+ "JOIN (SELECT r.id r_id, vr.priority priority FROM Recruiter r JOIN UpgradedRecruiter u ON r.upgradedRecruiter.id = u.id JOIN VipRecruiter vr ON u.vipRecruiter.id = vr.id "
			+ "WHERE u.expired >= :now) rank ON j.recruiter.id = rank.r_id "
			+ "WHERE j.closedDate >= :nowDate AND j.isAccepted = 1 AND j.hidden = 1 "
			+ "ORDER BY rank.priority ASC, j.datePost DESC")
	Page<Job> showJobs(@Param("nowDate") LocalDate nowDate, @Param("now") LocalDateTime now, Pageable pageJobs);

}
