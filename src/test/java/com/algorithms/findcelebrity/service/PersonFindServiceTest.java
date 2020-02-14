package com.algorithms.findcelebrity.service;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.algorithms.findcelebrity.exception.CelebrityNotFoundException;
import com.algorithms.findcelebrity.helper.DataHelper;
import com.algorithms.findcelebrity.repository.PersonRepository;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

public class PersonFindServiceTest {

	@Test
	public void findTheCelebrityNotFound() {
		PersonRepository personRepository = Mockito.mock(PersonRepository.class);
		CelebrityRuleService celebrityRuleService = Mockito.mock(CelebrityRuleService.class);
		PersonFindService personFindService = new PersonFindService(personRepository, celebrityRuleService);
		Mockito.when(personRepository.findAll()).thenReturn(Collections.emptyList());
		CelebrityNotFoundException exception = Assertions.assertThrows(CelebrityNotFoundException.class,
				() -> personFindService.findTheCelebrity());
		Assertions.assertTrue(exception.getMessage().contains(ServiceConst.MESSAGE_NOT_FOUND.getValue()));
	}

	@Test
	public void findTheCelebrityExist() {
		DataHelper dataHelper = new DataHelper();
		PersonRepository personRepository = Mockito.mock(PersonRepository.class);
		CelebrityRuleService celebrityRuleService = Mockito.mock(CelebrityRuleService.class);
		PersonFindService personFindService = new PersonFindService(personRepository, celebrityRuleService);
		Mockito.when(personRepository.findAll()).thenReturn(dataHelper.getPersonsWithCelebrity());
		Mockito.when(celebrityRuleService.checkCandidate(dataHelper.getCandidate(), personRepository.findAll()))
				.thenReturn(dataHelper.getCandidate());
		Mockito.when(celebrityRuleService.findCandidate(personRepository.findAll()))
				.thenReturn(dataHelper.getCandidate());
		Assertions.assertNotNull(personFindService.findTheCelebrity());
	}

}