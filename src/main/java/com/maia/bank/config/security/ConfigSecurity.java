package com.maia.bank.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	private static final String[] PUBLIC_MATCHERS_GET = { "/**" };
	private static final String[] PUBLIC_MATCHERS_POST = { "/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.POST,PUBLIC_MATCHERS_POST).permitAll()
			.anyRequest().authenticated();	
		
		http.headers().frameOptions().sameOrigin();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

}
