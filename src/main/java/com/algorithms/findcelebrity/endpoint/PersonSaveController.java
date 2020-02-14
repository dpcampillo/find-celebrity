package com.algorithms.findcelebrity.endpoint;

import java.util.List;

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
@RequiredArgsConstructor
public class PersonSaveController {

    private final PersonSaveService personSaveService;

    @PostMapping
    public void save(@RequestBody Person person) {
        personSaveService.savePerson(person);
    }

    @PostMapping("/list")
    public void savePersons(@RequestBody List<Person> persons) {
        personSaveService.savePersons(persons);
    }

    @PostMapping("/upload")
    public void importFile(@RequestParam(name = "file") MultipartFile file){
        personSaveService.importFile(file);
    }

}
