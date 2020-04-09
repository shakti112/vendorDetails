package com.auro.vendor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auro.vendor.vendorService.UserLoginService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	// @Autowired
	// public WebSecurity(BCryptPasswordEncoder bCryptPasswordEncoder) {
	// this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	// }

	@Autowired
	private UserLoginService userLoginService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable();

		http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
				.addFilter(getAuthenticationFilter());

		http.headers().frameOptions().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userLoginService).passwordEncoder(bCryptPasswordEncoder);
	}

	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager(), userLoginService);
		return filter;
	}

}
