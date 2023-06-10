package com.hotel_alura.controllers.RecordCRUD;

import com.hotel_alura.models.enums.SearchOptions;

import java.lang.reflect.Field;
import java.util.List;

public class RecordSelectors {
    public static List<String> searchSelector(String enumValue, Long searchParam) throws NoSuchFieldException, IllegalAccessException{
        List<String> readQueryResult;
        for (SearchOptions option : SearchOptions.values()) {
            Field stringValueField = SearchOptions.class.getDeclaredField("tabOption");
            stringValueField.setAccessible(true);

            String enumStringValue = (String) stringValueField.get(option);

            if (enumValue.equals(enumStringValue)) {
                readQueryResult = option.searching(searchParam);
                return readQueryResult;
            }
        }

        throw new NoSuchFieldException();
    }

    public static void editSelector(String enumValue, List<String> dataToUpdate, String refForSearch) throws NoSuchFieldException, IllegalAccessException{

        for (SearchOptions option : SearchOptions.values()) {
            Field stringValueField = SearchOptions.class.getDeclaredField("tabOption");
            stringValueField.setAccessible(true);

            String enumStringValue = (String) stringValueField.get(option);

            if (enumValue.equals(enumStringValue)) {
                option.editing(dataToUpdate, refForSearch);
            return;
            }
        }
        throw new NoSuchFieldException();
    }

    public static void deleteSelector(String enumValue, String refToDelete) throws NoSuchFieldException, IllegalAccessException{

        for (SearchOptions option : SearchOptions.values()) {
            Field stringValueField = SearchOptions.class.getDeclaredField("tabOption");
            stringValueField.setAccessible(true);

            String enumStringValue = (String) stringValueField.get(option);

            if (enumValue.equals(enumStringValue)) {
                option.deleting( refToDelete);
                return;
            }
        }
        throw new NoSuchFieldException();
    }


}
