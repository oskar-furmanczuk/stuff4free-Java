package net.oskarfurmanczuk.staff4free.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import net.oskarfurmanczuk.staff4free.repository.UserRepository;


@Service
public class ContextService {
	
	@Autowired
	private UserRepository userRepository;
	
	String currentUserName;
	public String getCurrentUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			currentUserName = authentication.getName();
		    
		}
		return currentUserName;
	}
	public String getCurrentUserId() {
		return userRepository.findByUsername(getCurrentUsername()).getId().toString();
	}
	

}
