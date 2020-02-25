package com.algorithms.findcelebrity.repository.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.repository.PersonRepository;


public class PersonRepositoryImpl implements PersonRepository {

    private final Set<Person> persons = new LinkedHashSet<>();

    @Override
    public Person save(Person person) {
        if(person.getKnows() == null){
            person.setKnows(new LinkedHashSet<>());
        }
        persons.add(person);
        return person;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }
}
