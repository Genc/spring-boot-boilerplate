package com.hiringglobal.mobile.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringglobal.mobile.model.RawTextJob;

public interface IRawTextJobRepo extends JpaRepository<RawTextJob, Integer> {
	Optional<RawTextJob> findByJobId(Integer id);
	
	List<RawTextJob> findByHiddenTrueAndIsAcceptedTrueAndClosedDateGreaterThanEqual(LocalDate closedDate);

}
