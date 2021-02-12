package net.oskarfurmanczuk.staff4free.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import net.oskarfurmanczuk.staff4free.models.Advert;
import net.oskarfurmanczuk.staff4free.services.AdvertService;
import net.oskarfurmanczuk.staff4free.services.LocationService;

@ResponseBody
@Controller
@RequestMapping("/rest")
public class RestController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private AdvertService advertService;

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	@GetMapping("/allCountries")
	public String getAllCountries() {
		return new Gson().toJson(locationService.getAllCountries() );
	}
	
	@GetMapping("/states")
	public String getStatesByCountry(@RequestParam String country) {
		return new Gson().toJson(locationService.getStatesByCountry(country));
		
	}
	@GetMapping("/cities")
	public String getCitiesByState(@RequestParam String state) {
		return new Gson().toJson(locationService.getCitiesByState(state));
		
	}
	@GetMapping("/loc")
	public String getTest() {
		return System.getProperty("user.dir").replace("\\", "/");
		
	}
	@GetMapping("/allAds")
	public List<Advert> getAllAds(
		      @RequestParam(defaultValue = "0") int page,
		      @RequestParam(defaultValue = "2") int size) {
		return advertService.findAll(page, size);
		
	}
	@GetMapping("/adsByTitle")
	public List<Advert> getAdsByTitle(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size,
			@RequestParam(defaultValue = "") String title) {
		return advertService.findByTitle(title, page, size);
		
	}
		
}
