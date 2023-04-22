package com.photoapp.discovery.service.photoappdiscoveryservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		//disable to microservice to communicate with eureka
		http.csrf().disable()
		.authorizeHttpRequests().anyRequest().authenticated()//any request to eureka will be authenticated with auth rules
		.and().httpBasic();//login username and password are authenticated
		return http.build();
		
	}
}
