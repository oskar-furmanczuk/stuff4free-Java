package net.oskarfurmanczuk.staff4free.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoCursor;

import net.oskarfurmanczuk.staff4free.models.Location;
import net.oskarfurmanczuk.staff4free.repository.LocationRepository;



@Service
public class LocationService  {
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;	
	
	
	List<Location> locationsInTheCountry;
	
	public List<Location> findByCountry(String country) {
		return locationRepository.findByCountry(country);
	}

	public List<String> getAllCountries() {
		
		List<String> countryList = new ArrayList<>();
		MongoCursor<String> cursor = mongoTemplate.getCollection("Locations").distinct("country", String.class).iterator();
		
		while (cursor.hasNext()) {
	        String category = (String)cursor.next();
	        countryList.add(category);
	    }
		return countryList;
	}
	
	
	public List<String> getStatesByCountry(String country) {
		
		locationsInTheCountry = locationRepository.findByCountry(country);
		
		List<String> theStates = new ArrayList<>();
		locationsInTheCountry.forEach(loc -> theStates.add(loc.getAdmin_name()));
		
		return new ArrayList<String> (new HashSet<String>(theStates)) ;
	}
	
	
	
	public List<String> getCitiesByState(String state) {
		List<String> theCities = new ArrayList<>();
		
		locationsInTheCountry.forEach(loc ->{
			 if (state.equals(loc.getAdmin_name())) {
				 theCities.add(loc.getCity());
			 		}
				}
			);
		
		return theCities;
	}

}
