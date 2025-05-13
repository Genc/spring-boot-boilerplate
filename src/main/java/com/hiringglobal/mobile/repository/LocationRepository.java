package com.hiringglobal.mobile.repository;


import com.hiringglobal.mobile.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository  extends JpaRepository<Location, Integer> {
}
