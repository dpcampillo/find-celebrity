package com.algorithms.findcelebrity.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.algorithms.findcelebrity.domain.Person;

public class DataHelper {

	public List<Person> getPersonsWithoutCandidate() {
		return Arrays.asList(new Person("A", Arrays.asList("B", "C")), new Person("B", Arrays.asList("A")),
				new Person("C", Arrays.asList("B")));
	}

	public List<Person> getPersonsWithCandidate() {
		return Arrays.asList(new Person("A", Arrays.asList("B", "C")), new Person("B", Collections.emptyList()),
				new Person("C", Collections.emptyList()));
	}

	public List<Person> getPersonsWithCelebrity() {
		return Arrays.asList(new Person("A", Arrays.asList("B", "C")), new Person("B", Collections.emptyList()),
				new Person("C", Arrays.asList("B")));
	}

	public Person getCandidate() {
		return new Person("B", Collections.emptyList());
	}

}
