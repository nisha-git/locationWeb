package com.udemy.location.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.location.entities.Location;
import com.udemy.location.repo.LocationRepository;

@RestController
@RequestMapping("/location")
public class LocationRestController {
	
	@Autowired
    private LocationRepository locationRepository;
	
	@GetMapping
	public List<Location> findAllLocation(){
		return locationRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Location findById(@PathVariable("id") Long id){
		Optional<Location> location = locationRepository.findById(id);
		if(location.isPresent()) {
			return location.get();
		}
		return null;
	}
	
	@PostMapping
	public Location addLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") Long id) {
		locationRepository.deleteById(id);
	}
	
}
