package com.hiringglobal.mobile.repository;

import com.hiringglobal.mobile.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location, Integer> {
    Location findLocationById(int locationId);

    Location findByName(String name);
}
