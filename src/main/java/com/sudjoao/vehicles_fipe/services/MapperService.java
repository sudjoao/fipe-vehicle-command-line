package com.sudjoao.vehicles_fipe.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class MapperService {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T toObject(String json, Class<T> className) {
        try {
            return objectMapper.readValue(json, className);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> className) {
        try {
            return objectMapper.convertValue(map, className);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro ao converter Map para objeto: " + e.getMessage(), e);
        }
    }

    public static <T> List<T> toObjectList(String json, Class<T> className) {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, className));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
