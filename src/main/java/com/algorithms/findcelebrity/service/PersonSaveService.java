package com.algorithms.findcelebrity.service;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.exception.WrongFormatException;
import com.algorithms.findcelebrity.repository.PersonRepository;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonSaveService {

	private final PersonRepository personRepository;
	private final ImportPersonService importPersonService;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> savePersons(List<Person> persons) {
		return persons.stream().map(personRepository::save).collect(Collectors.toList());
	}

	public List<Person> importFile(MultipartFile multipartFile) {
		try {
			return importPersonService.getList(multipartFile.getBytes()).stream().map(personRepository::save)
					.collect(Collectors.toList());
		} catch (IOException e) {
			throw new WrongFormatException(ServiceConst.WRONG_FORMAT_FILE.getValue(), e);
		}
	}

}
