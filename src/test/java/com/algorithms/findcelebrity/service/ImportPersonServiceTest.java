package com.algorithms.findcelebrity.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.algorithms.findcelebrity.domain.Person;

public class ImportPersonServiceTest {

	@Test
	public void converter() {
		byte[] data = "A,B".getBytes();
		ImportPersonService importPersonService = new ImportPersonService();
		Map<String, Set<String>> converterData = importPersonService.converter(data);
		Assertions.assertFalse(converterData.isEmpty());
	}
	
	@Test
	public void getList() {
		byte[] data = "A,B".getBytes();
		ImportPersonService importPersonService = new ImportPersonService();
		List<Person> dataList = importPersonService.getList(data);
		Assertions.assertFalse(dataList.isEmpty());
	}
	
	

}
