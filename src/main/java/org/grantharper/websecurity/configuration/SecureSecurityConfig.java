package org.grantharper.websecurity.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("secure")
public class SecureSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static Logger log = LoggerFactory.getLogger(SecureSecurityConfig.class);
	
	//put in some user authorization details here

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
			httpSecurity.authorizeRequests().antMatchers("/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout().permitAll();
		
	}
}
