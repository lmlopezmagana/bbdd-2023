package com.salesianostriana.dam.seguridad.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Bean
	public AuthenticationManager 
			authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		return authBuilder
			.authenticationProvider(daoAuthenticationProvider())
			.build();
		
		
	}
	
	/*@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
        		.username("admin")
        		.password("{noop}admin")
        		.roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user);
    }*/
	
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}*/
	
	
	
	@Bean 
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/css/**","/js/**","/webjars/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll();
		
		return http.build();
	}

}
