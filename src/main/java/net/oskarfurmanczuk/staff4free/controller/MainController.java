package net.oskarfurmanczuk.staff4free.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import net.oskarfurmanczuk.staff4free.models.Advert;
import net.oskarfurmanczuk.staff4free.models.User;
import net.oskarfurmanczuk.staff4free.services.AdvertService;
import net.oskarfurmanczuk.staff4free.services.ContextService;
import net.oskarfurmanczuk.staff4free.services.LocationService;
import net.oskarfurmanczuk.staff4free.services.MongoUserDetailsService;

@Controller
@SessionAttributes("user")

public class MainController {
	

	
	@Autowired
	private MongoUserDetailsService userService;
	
	@Autowired
	private ContextService contextService;
	
	@Autowired
	private AdvertService advertService ;
	
	@Autowired
	private LocationService locationService ;
	
	@GetMapping("/home")
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/register")
	public String getRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration-form";
	}
	
	@PostMapping("/saveRegisterionForm")
	public String getRegistrationForm(@ModelAttribute User user, Model model) {
		userService.registerNewUserAccount(user);
		return "successful-registration";
	}
	
	@GetMapping("/login")
	public String getLoginForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login-form";
	}
	
	
	@GetMapping("/newAdv")
	public String getNewAd(Model model) {
		
		Advert advert = new Advert();
		model.addAttribute("advert", advert);
		
		return "new-adv-form";
	}
	
	@PostMapping("/newAdv")
	public String getNewAd(@ModelAttribute Advert advert,
			@RequestParam MultipartFile imageFile) {
		advertService.saveAdvert(advert);
		System.out.println(advert.getId().toString());
		
		try {
			advertService.saveImage(imageFile, advert.getId().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getHome();
	}
	
	@GetMapping("/advList")
	public String getAdvList(Model model) {
		
		List<Advert> adverts = advertService.findAll(0, 2);
		model.addAttribute("adverts", adverts);
		
		return "adv-list";
	}
	
	

}
