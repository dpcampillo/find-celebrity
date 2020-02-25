package com.algorithms.findcelebrity.helper;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.algorithms.findcelebrity.domain.Person;

public class DataHelper {

	@SuppressWarnings("unchecked")
	private <T> Set<T> createSetCollection(T... records) {
		Set<T> collection = new LinkedHashSet<>();
		if (records != null)
			for (T data : records) {
				collection.add(data);
			}
		return collection;
	}

	public List<Person> getPersonsWithoutCandidate() {
		return Arrays.asList(new Person("A", createSetCollection("B", "C")), new Person("B", createSetCollection("A")),
				new Person("C", createSetCollection("B")));
	}

	public List<Person> getPersonsWithCandidate() {
		return Arrays.asList(new Person("A", createSetCollection("B", "C")), new Person("B", createSetCollection("B")),
				new Person("C", createSetCollection("C")));
	}

	public List<Person> getPersonsWithCelebrity() {
		return Arrays.asList(new Person("A", createSetCollection("B", "C")), new Person("B", createSetCollection()),
				new Person("C", createSetCollection("B")));
	}

	public Person getCandidate() {
		return new Person("B", createSetCollection());
	}

}
