package com.udemy.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.location.entities.Location;
import com.udemy.location.repo.LocationRepository;
import com.udemy.location.services.LocationService;
import com.udemy.location.utilities.EmailUtility;
import com.udemy.location.utilities.ReportsUtility;

@Controller
public class LocationController {

	@Autowired
	private LocationRepository repo;

	@Autowired
	private LocationService locationService;

	@Autowired
	private EmailUtility emailUtility;

	@Autowired
	private ReportsUtility reportUtility;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/addLocation", method = RequestMethod.GET)
	public String showAddLocation() {
		return "addLocation";
	}

	@RequestMapping(value = "/addLocation", method = RequestMethod.POST)
	public String addLocation(@ModelAttribute("location") Location location, ModelMap map) {
		System.out.println(location.getId());
		if (location.getId() >= 0) {
			
			locationService.updateLocation(location);
		} else {
			locationService.saveLocation(location);
			// emailUtility.sendEmail("nisha15ashok@gmail.com", "HELLO HUSBAND","This is mail body message");
			map.addAttribute("msg", "Location Added Successfully");
			
		}
		map.addAttribute("locations", locationService.getListOfLocation());
		return "listLocation";
	}

	@RequestMapping(value = "/edit")
	public String showEditLocation(@RequestParam("id") long id, ModelMap map) {
		Location location = locationService.findById(id);
		map.addAttribute("location", location);
		return "addLocation";
	}

	@RequestMapping(value = "/generateReport", method = RequestMethod.GET)
	public String generateReport(ModelMap map) {
		String realPath = servletContext.getRealPath("/");
		List<Object[]> typesCount = repo.getDataOfLOcationType();
		reportUtility.generateReport(realPath, typesCount);
		map.addAttribute("locations", locationService.getListOfLocation());
		return "listLocation";
	}
	
	@RequestMapping(value = "/delete")
	public String DeleteLocation(@RequestParam("id") long id, ModelMap map) {
		 locationService.deleteLocation(id);;
		 map.addAttribute("locations", locationService.getListOfLocation());
		return "listLocation";
	}

}
