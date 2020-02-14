package com.algorithms.findcelebrity.repository;

import com.algorithms.findcelebrity.domain.Person;

import java.util.List;

public interface PersonRepository {

    Person save(Person person);

    List<Person> findAll();

}
