package com.algorithms.findcelebrity.endpoint;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.service.PersonFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons/find")
@RequiredArgsConstructor
public class PersonFindController {

    private final PersonFindService personFindService;

    @GetMapping("/celebrity")
    public Person findTheCelebrity() {
        return personFindService.findTheCelebrity();
    }
}
