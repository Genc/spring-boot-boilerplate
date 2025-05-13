package com.hiringglobal.mobile.service;


import com.hiringglobal.mobile.config.RenderException;

import com.hiringglobal.mobile.model.Location;
import com.hiringglobal.mobile.repository.ILocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private ILocationRepository locationRepository;

    private ValidateService validateService;

    public LocationServiceImpl(ILocationRepository locationRepository, ValidateService validateService) {
        this.locationRepository = locationRepository;
        this.validateService = validateService;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(int theId) {
        Optional<Location> result = locationRepository.findById(theId);

        Location location = null;

        if(result.isPresent()) {
            location = result.get();
        }else{
            throw new RuntimeException("Id location not found ??? -> " + theId );
        }

        return location;
    }

    @Override
    public void save(Location location) {
        Location locate = locationRepository.findByName(location.getName());
        boolean isValid = validateService.validateString(location.getName());
        if(isValid){
            if(locate == null && location.getName() != null && location.getName() != ""){
                locationRepository.save(location);
            }else{
                throw new RenderException("Location name already exits or not must be null !");
            }
        }else{
            throw new RenderException("Characters is wrong");
        }
    }

    @Override
    public void deleteById(int theId) {
        locationRepository.deleteById(theId);
    }
}
