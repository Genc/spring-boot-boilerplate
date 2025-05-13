package com.hiringglobal.mobile.repository;

import com.hiringglobal.mobile.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("SELECT DISTINCT j FROM Job j " +
            "INNER JOIN j.recruiter r " +
            "INNER JOIN r.company c " +
            "LEFT JOIN FETCH j.locations loc " +
            "INNER JOIN j.category cat " +
            "WHERE ((:keyword IS NULL OR LOWER(j.title) LIKE %:keyword%) OR LOWER(c.name) LIKE %:keyword%) " +
            "AND (:categoryId IS NULL OR cat.id = :categoryId) " +
            "AND (loc.id = :locationId OR :locationId IS NULL) " +
            "AND j.isAccepted = true " +
            "AND j.hidden= true ")
    List<Job> searchJobs(@Param("keyword") String keyword,
                         @Param("categoryId") Integer categoryId,
                         @Param("locationId") Integer locationId);

    

    @Query("SELECT j FROM Job j " +
            "WHERE j.recruiter.id = :recruiterId " +
            "ORDER BY j.datePost DESC")
    List<Job> findTop3NewestJobsByRecruiter(@Param("recruiterId") Integer recruiterId);

    Long countByRecruiterIdAndHiddenAndIsAccepted(Integer id,Boolean hidden, Boolean accepted);
    
    List<Job> findAllByRecruiterId(Integer recruiterId);
    
    Optional<Job> findByIdAndRecruiterId(Integer id,Integer recruiterId);

}
