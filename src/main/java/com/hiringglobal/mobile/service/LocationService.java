package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();

    Location findById(int theId);

    void save(Location location);

    void deleteById(int theId);
}
