package com.hotel_alura.controllers.RecordCRUD;

import com.hotel_alura.models.enums.QueryOptions;

import java.lang.reflect.Field;
import java.util.List;

public class QuerySelectors {

    public static void createSelector(String enumValue, long id ,List<String> dataToCreate) throws NoSuchFieldException, IllegalAccessException{

        QueryOptions option = isValidEntity(enumValue);

        if (option != null && !(QueryOptions.GUEST.searching(id).isEmpty())) {
            option.creating(dataToCreate, id);
            return;
        }
        throw new NoSuchFieldException();
    }

    public static List<String> searchSelector(String enumValue, Long searchParam) throws NoSuchFieldException, IllegalAccessException{
        List<String> readQueryResult;
        QueryOptions option = isValidEntity(enumValue);

        if (option != null) {
                readQueryResult = option.searching(searchParam);
                return readQueryResult;
        }
        throw new NoSuchFieldException();
    }

    public static void editSelector(String enumValue, List<String> dataToUpdate, String refForSearch) throws NoSuchFieldException, IllegalAccessException{

        QueryOptions option = isValidEntity(enumValue);

        if (option != null) {
            option.editing(dataToUpdate, refForSearch);
            return;
        }
        throw new NoSuchFieldException();
    }

    public static void deleteSelector(String enumValue, String refToDelete) throws NoSuchFieldException, IllegalAccessException{

        QueryOptions option = isValidEntity(enumValue);

        if ( option != null) {
            option.deleting( refToDelete);
            return;
        }
        throw new NoSuchFieldException();
    }

    private static QueryOptions isValidEntity(String enumValue) throws NoSuchFieldException, IllegalAccessException {
        for (QueryOptions option : QueryOptions.values()) {
            Field stringValueField = QueryOptions.class.getDeclaredField("tabOption");
            stringValueField.setAccessible(true);

            String enumStringValue = (String) stringValueField.get(option);

            if (enumValue.equals(enumStringValue)) {
                return option;
            }
        }
        return null;
    }


}
