package com.dal.firstsprboot.service;

import com.dal.firstsprboot.entity.ForeignTour;
import com.dal.firstsprboot.entity.LocalTour;
import com.dal.firstsprboot.entity.Traveller;

public interface TravellerService {

	public Traveller addTraveller(Traveller traveller);
	public LocalTour saveLocalTourRequest(LocalTour localTour);
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour);
	public Traveller updateTraveller(Traveller traveller, Long travelId);
	public Traveller deleteTraveller(Traveller traveller, Long travelId);
	public Traveller getTraveller(Traveller traveller, Long travelId);
	
}
