package com.algorithms.findcelebrity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algorithms.findcelebrity.repository.PersonRepository;
import com.algorithms.findcelebrity.repository.impl.PersonRepositoryImpl;
import com.algorithms.findcelebrity.service.ImportPersonService;

@Configuration
public class BeanConfig {
	
	@Bean
	public PersonRepository personRepository() {
		return new PersonRepositoryImpl();
	}
	
	@Bean
	public ImportPersonService importPersonService() {
		return new ImportPersonService();
	}

}
