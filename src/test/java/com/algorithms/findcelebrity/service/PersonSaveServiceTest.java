package com.algorithms.findcelebrity.service;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.exception.WrongFormatException;
import com.algorithms.findcelebrity.helper.DataHelper;
import com.algorithms.findcelebrity.repository.PersonRepository;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

public class PersonSaveServiceTest {

	@Test
	public void savePerson() {
		Person person = new DataHelper().getCandidate();
		PersonRepository personRepository = Mockito.mock(PersonRepository.class);
		PersonSaveService personSaveService = new PersonSaveService(personRepository,
				Mockito.mock(ImportPersonService.class));
		when(personRepository.save(person)).thenReturn(person);
		Assertions.assertNotNull(personSaveService.savePerson(person));
	}

	@Test
	public void savePersonList() {
		List<Person> persons = new DataHelper().getPersonsWithCandidate();
		PersonRepository personRepository = Mockito.mock(PersonRepository.class);
		PersonSaveService personSaveService = new PersonSaveService(personRepository,
				Mockito.mock(ImportPersonService.class));
		when(personRepository.save(ArgumentMatchers.any())).thenReturn(ArgumentMatchers.any());
		Assertions.assertFalse(personSaveService.savePersons(persons).isEmpty());
	}

	@Test
	public void saveImportFile() {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("import-file", "import-file.csv", null,
				"A,B".getBytes());
		ImportPersonService importPersonService = Mockito.mock(ImportPersonService.class);
		PersonRepository personRepository = Mockito.mock(PersonRepository.class);
		PersonSaveService personSaveService = new PersonSaveService(personRepository, importPersonService);
		when(importPersonService.getList("A,B".getBytes())).thenReturn(new DataHelper().getPersonsWithCandidate());
		when(personRepository.save(ArgumentMatchers.any())).thenReturn(ArgumentMatchers.any());
		Assertions.assertFalse(personSaveService.importFile(mockMultipartFile).isEmpty());
	}

	@Test
	public void saveImportFileWithError() {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("import-file", "import-file.csv", null,
				new byte[1]);
		ImportPersonService importPersonService = Mockito.mock(ImportPersonService.class);
		PersonRepository personRepository = Mockito.mock(PersonRepository.class);
		PersonSaveService personSaveService = new PersonSaveService(personRepository, importPersonService);
		when(importPersonService.getList(ArgumentMatchers.any()))
				.thenThrow(new WrongFormatException(ServiceConst.WRONG_FORMAT_FILE.getValue(), ArgumentMatchers.any()));
		WrongFormatException exception = Assertions.assertThrows(WrongFormatException.class,
				() -> personSaveService.importFile(mockMultipartFile));
		Assertions.assertTrue(exception.getMessage().contains(ServiceConst.WRONG_FORMAT_FILE.getValue()));

	}

}
