package com.algorithms.findcelebrity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.exception.CelebrityNotFoundException;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

@Service
public class CelebrityRuleService {

	public Person checkCandidate(Person candidate, List<Person> persons) {
		return persons.stream().filter(predicate -> predicate.getKnows().contains(candidate.getName()))
				.count() == persons.size() - 1 ? candidate : null;
	}

	public Person findCandidate(List<Person> persons) {
		return persons.stream().filter(predicate -> predicate.getKnows().isEmpty()).findFirst()
				.orElseThrow(() -> new CelebrityNotFoundException(ServiceConst.MESSAGE_NOT_FOUND.getValue()));
	}

}
