package com.algorithms.findcelebrity.endpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.algorithms.findcelebrity.exception.CelebrityNotFoundException;
import com.algorithms.findcelebrity.helper.DataHelper;
import com.algorithms.findcelebrity.service.PersonFindService;
import com.algorithms.findcelebrity.service.cons.ServiceConst;

public class PersonFindControllerTest {

	private MockMvc mockMvc;

	@Mock
	private PersonFindService personFindService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(new PersonFindController(personFindService))
				.setControllerAdvice(new RestExceptionHandler()).build();
	}

	@Test
	public void findCelebrity() throws Exception {
		Mockito.when(personFindService.findTheCelebrity()).thenReturn(new DataHelper().getCandidate());
		mockMvc.perform(
				MockMvcRequestBuilders.get("/persons/find/celebrity").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void findCelebrityWithError() throws Exception {
		Mockito.when(personFindService.findTheCelebrity())
				.thenThrow(new CelebrityNotFoundException(ServiceConst.MESSAGE_NOT_FOUND.getValue()));
		mockMvc.perform(
				MockMvcRequestBuilders.get("/persons/find/celebrity").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
