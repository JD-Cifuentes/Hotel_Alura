package com.hotel_alura.controllers;

import com.hotel_alura.models.enums.SearchOptions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RecordSelectors {
    public static List<String> searchSelector(String enumValue, Long searchParam){
        List<String> readQueryResult = new ArrayList<>();
        try {
            for (SearchOptions option : SearchOptions.values()) {
                Field stringValueField = SearchOptions.class.getDeclaredField("tabOption");
                stringValueField.setAccessible(true);

                String enumStringValue = (String) stringValueField.get(option);

                if (enumValue.equals(enumStringValue)) {
                    readQueryResult = option.searching(searchParam);
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        return readQueryResult;
    }

    public static void editSelector(String enumValue, StringBuilder dataToUpdate){
        try {
            for (SearchOptions option : SearchOptions.values()) {
                Field stringValueField = SearchOptions.class.getDeclaredField("tabOption");
                stringValueField.setAccessible(true);

                String enumStringValue = (String) stringValueField.get(option);

                if (enumValue.equals(enumStringValue)) {
                    //todo implementar la acción que permitirá editar los campos enviados según la tab seleccionada en la UI
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }


    }


}
