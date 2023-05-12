package com.dal.firstsprboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.firstsprboot.entity.ForeignTour;
import com.dal.firstsprboot.entity.LocalTour;
import com.dal.firstsprboot.entity.Traveller;
import com.dal.firstsprboot.repository.ForeignTourRepository;
import com.dal.firstsprboot.repository.LocalTourRepository;
import com.dal.firstsprboot.repository.TravellerRepository;

@Service
public class TravellerServiceImpl implements TravellerService{

	@Autowired
	TravellerRepository travellerRepository;
	@Autowired
	private LocalTourRepository localTourRepository;
	@Autowired
	private ForeignTourRepository foreignTourRepository;
	
	@Override
	public Traveller addTraveller(Traveller traveller) {
		
		return travellerRepository.save(traveller);
	}
	

	@Override
	public LocalTour saveLocalTourRequest(LocalTour localTour) {

		Traveller traveller = localTour.getTrtourist();
		localTour.setTrtourist(traveller);
		return localTourRepository.save(localTour);
	}

	@Override
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour) {
		System.out.println("-----------foreign Tour -------" +foreignTour);
		Traveller traveller = foreignTour.getTrtourist();
		foreignTour.setTrtourist(traveller);
		return foreignTourRepository.save(foreignTour);
	}


	@Override
	public Traveller updateTraveller(Traveller traveller, Long travellerId) {
		Traveller travellers = travellerRepository.findById(travellerId).get();
		travellers.setTravellerPwd(traveller.getTravellerPwd());
		travellers.setTravellerName(traveller.getTravellerName());
		travellers.setRoles(traveller.getRoles());
			    return travellerRepository.save(travellers);
	}


	@Override
	public Traveller deleteTraveller(Traveller traveller, Long travelId) {
		 Traveller travellerd = travellerRepository.findById(travelId).get();
		 travellerd.setTravellerPwd(traveller.getTravellerPwd());
			travellerd.setTravellerName(traveller.getTravellerName());
			travellerd.setRoles(traveller.getRoles());
		 travellerRepository.delete(travellerd);
		 return travellerd;
	}


	@Override
	public Traveller getTraveller(Traveller traveller, Long travelId) {
		 Traveller travellerg = travellerRepository.findById(travelId).get();
		return travellerg;
	}
	
//	public void run(String... strings) throws Exception {
////		Traveller traveller = Traveller.getTrtourist();
////		foreignTour.setTrtourist(traveller);
//        List<Traveller> persons = new ArrayList<>();
//        persons.add(new Traveller("Tom", new IDCard()));
//        persons.add(new Traveller("Daisy", new IDCard()));
//        persons.add(new Traveller("Alex", new IDCard()));
//        travellerRepository.saveAll(persons);
//    }

	
}
