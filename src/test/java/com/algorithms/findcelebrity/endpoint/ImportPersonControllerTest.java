package com.algorithms.findcelebrity.endpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.algorithms.findcelebrity.exception.WrongFormatException;
import com.algorithms.findcelebrity.service.PersonSaveService;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

public class ImportPersonControllerTest {

	private MockMvc mockMvc;

	@Mock
	private PersonSaveService personSaveService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(new PersonSaveController(personSaveService))
				.setControllerAdvice(new RestExceptionHandler()).build();
	}

	@Test
	public void importFileWithError() throws Exception {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "A.B".getBytes());
		Mockito.when(personSaveService.importFile(mockMultipartFile))
				.thenThrow(new WrongFormatException(ServiceConst.WRONG_FORMAT_FILE.getValue(), new Exception()));
		mockMvc.perform(MockMvcRequestBuilders.multipart("/persons/save/upload").file(mockMultipartFile))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
