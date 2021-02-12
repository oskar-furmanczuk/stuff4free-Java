package net.oskarfurmanczuk.staff4free.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import net.oskarfurmanczuk.staff4free.models.User;
import net.oskarfurmanczuk.staff4free.repository.UserRepository;

@Service
@Component
public class MongoUserDetailsService implements UserDetailsService{
  @Autowired
  private UserRepository repository;
  
  
  @Autowired
  private PasswordEncoder passwordEncoder;
   
  public void registerNewUserAccount(User accountDto) throws RuntimeException {


	  accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
      
      repository.save(accountDto);
  }
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = repository.findByUsername(username);
	
    if(user == null) {
      throw new UsernameNotFoundException("Not found " + username + " user" );
    }
    
    return new MyUserDetails(user);
  }
}
  
