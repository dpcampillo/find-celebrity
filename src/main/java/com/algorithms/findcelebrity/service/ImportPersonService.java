package com.algorithms.findcelebrity.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.algorithms.findcelebrity.domain.Person;
import com.algorithms.findcelebrity.exception.WrongFormatException;

public class ImportPersonService {

    public static final String COMMA_DELIMITER = ",";
    public static final int INDEX_PERSON = 0;
    public static final int INDEX_KNOWS = 1;

    public Map<String, Set<String>> converter(byte[] content) {
        try {
            List<List<String>> records = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(content)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(COMMA_DELIMITER);
                    records.add(Arrays.asList(values));
                }
            }

            Map<String, Set<String>> converterMap = new HashMap<>();
            Set<String> setKnows = null;
            for (List<String> dataRow : records) {
                if (converterMap.containsKey(dataRow.get(INDEX_PERSON))) {
                    setKnows = converterMap.get(dataRow.get(INDEX_PERSON));
                } else {
                    setKnows = new LinkedHashSet<>();
                    converterMap.put(dataRow.get(INDEX_PERSON), setKnows);
                }
                if (dataRow.size() > INDEX_KNOWS)
                    setKnows.add(dataRow.get(INDEX_KNOWS));
            }
            return converterMap;
        } catch (Exception e) {
            throw new WrongFormatException("Error occurred while loading object list from file ", e);
        }
    }

    public List<Person> getList(byte[] content) {
        return converter(content).entrySet().stream()
                .map(mapper -> new Person(mapper.getKey(), new LinkedHashSet<>(mapper.getValue())))
                .collect(Collectors.toList());
    }

}
