package com.algorithms.findcelebrity.endpoint;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.service.PersonSaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/persons/save")
@Api(tags = {"Api for saving persons"})
@SwaggerDefinition(tags = {
        @Tag(name = "Api for saving persons", description = "Api for saving persons")
})
@RequiredArgsConstructor
public class PersonSaveController {

    private final PersonSaveService personSaveService;

    @ApiOperation(value = "Save a single person with its relations")
    @PostMapping
    public void save(@RequestBody Person person) {
        personSaveService.savePerson(person);
    }

    @ApiOperation(value = "Save a list of person with its relations")
    @PostMapping("/list")
    public void savePersons(@RequestBody List<Person> persons) {
        personSaveService.savePersons(persons);
    }

    @ApiOperation(value = "Save a list of person into file format")
    @PostMapping("/upload")
    public void importFile(@RequestParam(name = "file") MultipartFile file){
        personSaveService.importFile(file);
    }

}
