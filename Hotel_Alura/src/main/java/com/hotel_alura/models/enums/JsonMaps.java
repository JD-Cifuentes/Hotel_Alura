package com.hotel_alura.models.enums;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel_alura.models.ComboBoxKeyValue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public enum JsonMaps {
    NATION("data_formats/nationalities.json");

    private List<ComboBoxKeyValue> jsonMap;
    private final String path;

    JsonMaps(String path){
        this.path = path;
        initMap(this.path);
    }

    private void initMap(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream streamedPath = getClass().getClassLoader().getResourceAsStream(path);
        try {
            jsonMap = objectMapper.readValue(streamedPath, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ComboBoxKeyValue> getJsonList(){
        return this.jsonMap;
    }


}
