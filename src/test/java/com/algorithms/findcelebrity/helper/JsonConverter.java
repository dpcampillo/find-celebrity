package com.algorithms.findcelebrity.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
	
	public static String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String a = objectMapper.writeValueAsString(obj);
            return a;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
}
