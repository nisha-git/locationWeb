package com.udemy.location;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.udemy.location.entities.Location;
import com.udemy.location.services.LocationService;

@SpringBootTest
class LocationWebApplicationTests {
   
	@Autowired
	private LocationService locationService;
	
	/*@Test
    public void testSaveLocation() {
		Location location = new Location();
	   	location.setName("Jabalpur");
	   	location.setCode("JBL");
	   	location.setType("Urban");
		locationService.saveLocation(location);
    }
   
	
/*	@Test
     public void testUpdateLocation() {
		Location location = locationService.findById(2);
    	location.setName("Bijuri");
    	location.setCode("BJR");
    	location.setType("Rural");
		locationService.updateLocation(location);
     }*/
    
	@Test
    public void testGetLocation() {
		Location location = locationService.findById(2);
		System.out.println(location);
    }*/

	@Test
    public void testFindAllLocation() {
		
		List<Location> listOfLocation = locationService.getListOfLocation();
		System.out.println(listOfLocation);
    }

	@Test
    public void testDeleteLocation() {
		
		locationService.deleteLocation(1);
    }
	

}
