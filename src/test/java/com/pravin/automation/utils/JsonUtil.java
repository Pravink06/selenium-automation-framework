package com.pravin.automation.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    public static List<Map<String, Object>> getJsonData(String filePath){

        try{
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Map<String, Object>>>(){}
            );

        } catch (Exception e){
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
}