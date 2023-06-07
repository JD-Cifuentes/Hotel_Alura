package com.hotel_alura.models.enums;

import com.hotel_alura.controllers.readers.RecordSearch;
import com.hotel_alura.controllers.updates.RecordEdit;

import java.util.List;

public enum SearchOptions {
    GUEST("Huéspedes") {
        @Override
        public List<String> searching(Long searchParam) {
            return new RecordSearch()
                    .searchGuestByDocument(searchParam);
        }
        @Override
        public void editing(List<String> dataToUpdate, String refForSearch) {
           new RecordEdit().updateGuestByDocument(dataToUpdate, refForSearch);
        }
    },
    RESERVE("Reservas") {
        @Override
        public List<String> searching(Long searchParam) {
            return new RecordSearch()
                    .searchReserveByReserveId(searchParam);
        }
        @Override
        public void editing(List<String> dataToUpdate, String refForSearch) {
            new RecordEdit().updateReserveByReserveId(dataToUpdate, refForSearch);
        }
    };

    private final String tabOption;
    SearchOptions(String tabOption) {
        this.tabOption = tabOption;
    }

    @Override
    public String toString() {
        return tabOption;
    }

    public abstract List<String> searching(Long searchParam);

    public abstract void editing(List<String> dataToUpdate, String refForSearch);



}
