package com.udemy.location.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.location.entities.Location;
import com.udemy.location.repo.LocationRepository;
import com.udemy.location.services.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepo;

	@Override
	public void saveLocation(Location location) {
       
		locationRepo.save(location);
	}

	@Override
	public void updateLocation(Location location) {
      locationRepo.save(location);
	}

	@Override
	public Location findById(long id) {
        Optional<Location> location = locationRepo.findById(id);
        if(location.isPresent()) {
        	return location.get();
        }
		return null;
	}

	@Override
	public List<Location> getListOfLocation() {
        List<Location> locations = locationRepo.findAll();
		return locations;
	}

	@Override
	public void deleteLocation(long id) {
       locationRepo.deleteById(id);		
	}

}
