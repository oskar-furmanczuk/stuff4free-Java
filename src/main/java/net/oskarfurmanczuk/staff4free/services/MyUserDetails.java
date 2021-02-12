package net.oskarfurmanczuk.staff4free.services;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import net.oskarfurmanczuk.staff4free.models.User;

public class MyUserDetails implements UserDetails {
	
	private String username;
	private String password;


	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_USER");
		
		return Arrays.asList(sga);
	}
	
	
	public MyUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
