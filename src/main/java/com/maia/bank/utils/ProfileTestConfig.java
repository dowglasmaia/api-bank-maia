package com.maia.bank.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

@Configuration
@Profile("test")
public class ProfileTestConfig {
	
	@Autowired
	private TestsIntegrationsDB dbTestsServices;

	@Bean
	public boolean instantiateDataBase() throws ParseException {

		dbTestsServices.instanciateTestDatabase();
		return true;
	}

}
