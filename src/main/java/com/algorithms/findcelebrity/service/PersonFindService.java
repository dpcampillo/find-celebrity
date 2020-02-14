package com.algorithms.findcelebrity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.exception.CelebrityNotFoundException;
import com.algorithms.findcelebrity.repository.PersonRepository;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonFindService {

    private final PersonRepository personRepository;
    private final CelebrityRuleService celebrityRuleService;

    public Person findTheCelebrity() {
        List<Person> persons = personRepository.findAll();
        return Optional.ofNullable(celebrityRuleService.checkCandidate(celebrityRuleService.findCandidate(persons), persons))
                .orElseThrow(() -> new CelebrityNotFoundException(ServiceConst.MESSAGE_NOT_FOUND.getValue()));
    }
}
