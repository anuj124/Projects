package com.greatlearning.employeeManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employeeManagement.service.UserDetailsServiceImp;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImp();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers(HttpMethod.POST, "/user/save", "/employee/save").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/employee/list", "/user/list", "/employee/list/{id}", "/user/list/{id}")
				.hasAnyAuthority("USER", "ADMIN").antMatchers(HttpMethod.PUT, "/employee/update/{id}")
				.hasAuthority("ADMIN").antMatchers(HttpMethod.DELETE, "/employee/delete/{id}", "/user/delete/{id}")
				.hasAuthority("ADMIN").anyRequest().authenticated().and().httpBasic().and().formLogin().and().logout()
				.logoutSuccessUrl("/login").permitAll().and().cors().and().csrf().disable();
	}

}
