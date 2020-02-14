package com.algorithms.findcelebrity.endpoint;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.service.PersonFindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons/find")
@Api(tags = {"Api for finding celebrities"})
@SwaggerDefinition(tags = {
        @Tag(name = "Api for finding celebrities", description = "Api for finding celebrities")
})
@RequiredArgsConstructor
public class PersonFindController {

    private final PersonFindService personFindService;

    @ApiOperation(value = "Find the celebrity in the application")
    @GetMapping("/celebrity")
    public Person findTheCelebrity() {
        return personFindService.findTheCelebrity();
    }
}
