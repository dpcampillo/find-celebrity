package com.algorithms.findcelebrity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.exception.CelebrityNotFoundException;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

@Service
public class CelebrityRuleService {

	/**
	 * Check if the candidate found is a celebrity
	 * 
	 * @param candidate
	 * @param persons
	 * @return
	 */
	public Person checkCandidate(Person candidate, List<Person> persons) {
		return persons.stream().filter(predicate -> !predicate.equals(candidate) 
				&& predicate.getKnows().contains(candidate.getName()))
				.count() == persons.size() - 1 ? candidate : null;
	}
	
	/**
	 * looking for a candidate to be a celebrity
	 * 
	 * @param persons
	 * @return
	 */
	public Person findCandidate(List<Person> persons) {
		for(Person person : persons) {
			if(isCandidate(person)) {
				return person;
			}
		}
		throw new CelebrityNotFoundException(ServiceConst.MESSAGE_NOT_FOUND.getValue());
	}

	/**
	 * Verify if a person is a candidate
	 * @param person
	 * @return
	 */
	public boolean isCandidate(Person person) {
		for (String knows : person.getKnows()) {
			if (!knows.equals(person.getName()))
				return false;
		}
		return true;
	}

}
