package com.algorithms.findcelebrity.service.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.exception.CelebrityNotFoundException;
import com.algorithms.findcelebrity.helper.DataHelper;
import com.algorithms.findcelebrity.service.CelebrityRuleService;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

public class CelebrityRuleTest {

	@Test
	public void findCandidate() {
		CelebrityRuleService celebrityRuleService = new CelebrityRuleService();
		Person person = celebrityRuleService.findCandidate(new DataHelper().getPersonsWithCandidate());
		Assertions.assertNotNull(person);
	}

	@Test
	public void findCandidateNotFound() {
		CelebrityRuleService celebrityRuleService = new CelebrityRuleService();
		CelebrityNotFoundException celebrityNotFoundException = Assertions.assertThrows(
				CelebrityNotFoundException.class,
				() -> celebrityRuleService.findCandidate(new DataHelper().getPersonsWithoutCandidate()));
		Assertions.assertTrue(
				celebrityNotFoundException.getMessage().contains(ServiceConst.MESSAGE_NOT_FOUND.getValue()));
	}

	@Test
	public void checkCandidate() {
		CelebrityRuleService celebrityRuleService = new CelebrityRuleService();
		DataHelper dataHelper = new DataHelper();
		Person candidate = dataHelper.getCandidate();
		Assertions.assertNull(celebrityRuleService.checkCandidate(candidate, dataHelper.getPersonsWithCandidate()));
	}

	@Test
	public void checkCandidateExist() {
		CelebrityRuleService celebrityRuleService = new CelebrityRuleService();
		DataHelper dataHelper = new DataHelper();
		Person candidate = dataHelper.getCandidate();
		Assertions.assertNotNull(celebrityRuleService.checkCandidate(candidate, dataHelper.getPersonsWithCelebrity()));
	}

}
