package net.oskarfurmanczuk.staff4free.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.oskarfurmanczuk.staff4free.services.MongoUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	  MongoUserDetailsService userDetailsService;
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    	.antMatchers(new String[]{"/login/**","/register/**"}).permitAll()
	    	.and()
	    	.formLogin()
	        .loginPage("/login")
	        .failureUrl("/login?error")
	        .and()
	        .logout().invalidateHttpSession(true)
	        .clearAuthentication(true)
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/home")
	      
	        
	        ;
	  }
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
	  }

	  
	  @Override
	  public void configure(AuthenticationManagerBuilder builder) throws Exception {
	   builder.userDetailsService(userDetailsService);
	  }

}
