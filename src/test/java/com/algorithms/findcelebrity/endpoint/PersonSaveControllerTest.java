package com.algorithms.findcelebrity.endpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.algorithms.findcelebrity.config.BeanConfig;
import com.algorithms.findcelebrity.helper.DataHelper;
import com.algorithms.findcelebrity.helper.JsonConverter;
import com.algorithms.findcelebrity.service.PersonSaveService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {BeanConfig.class,PersonSaveController.class, PersonSaveService.class})
@WebMvcTest
public class PersonSaveControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void savePerson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/persons/save").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonConverter.asJsonString(new DataHelper().getCandidate())))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
