package com.udemy.location.services;

import java.util.List;

import com.udemy.location.entities.Location;

public interface LocationService {

	public void saveLocation(Location location);

	public void updateLocation(Location location);

	public Location findById(long id);

	public List<Location> getListOfLocation();
	
	public void deleteLocation(long id);

}
