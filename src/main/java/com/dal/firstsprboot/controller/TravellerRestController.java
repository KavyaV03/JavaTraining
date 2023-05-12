package com.dal.firstsprboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dal.firstsprboot.entity.ForeignTour;
import com.dal.firstsprboot.entity.LocalTour;
import com.dal.firstsprboot.entity.Traveller;
import com.dal.firstsprboot.service.TravellerService;

@RestController
public class TravellerRestController {
	
	@Autowired
	TravellerService travellerService;
	
	@PostMapping("/addTraveller")
	public Traveller addTraveller(@RequestBody Traveller traveller)
	{
		return travellerService.addTraveller(traveller);
	}
	
	@GetMapping("/welcome")
	public String helloApp() {
		return "Hi traveller- KAVYA";
	}
	@GetMapping("/detailsTravel")
	public Traveller getTraveller(Traveller traveller,String travellerId) {
		return travellerService.getTraveller(traveller,Long.parseLong(travellerId));
	}
	@PutMapping("/updatetraveller")
	public Traveller updateTraveller(@RequestBody Traveller traveller, @RequestParam(value = "id") String travellerId){
		System.out.println(""+travellerId);
		return travellerService.updateTraveller(traveller, Long.parseLong(travellerId));
	}
	
	@DeleteMapping("/deleteTraveller")
	public Traveller deleteTraveller(@RequestBody Traveller traveller, @RequestParam(value = "id") String travellerId){
		System.out.println(""+travellerId);
		return travellerService.deleteTraveller(traveller, Long.parseLong(travellerId));
	}

	@PostMapping("/requestlocaltour")
	public LocalTour saveLocalTourRequest(@RequestBody LocalTour localTour) {
		return travellerService.saveLocalTourRequest(localTour);
	}

	@PostMapping("/requestforeigntour")
	
	public ForeignTour saveForeignTourRequest(@RequestBody ForeignTour foreignTour) {
		System.out.println("****** From Controller Foreign ******" + foreignTour);
		return travellerService.saveForeignTourRequest(foreignTour);
	}
	
}
