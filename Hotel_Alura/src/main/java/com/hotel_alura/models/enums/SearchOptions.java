package com.hotel_alura.models.enums;

import com.hotel_alura.controllers.readers.RecordSearch;
import java.util.List;

public enum SearchOptions {
    GUEST("Huéspedes") {
        @Override
        public List<String> searching(Long searchParam) {
            return new RecordSearch().SearchGuestByDocument(searchParam);
        }

        @Override
        public List<String> editing(Long searchParam) {
            return null;
        }
    },
    RESERVE("Reservas") {
        @Override
        public List<String> searching(Long searchParam) {
            return new RecordSearch()
                    .SearchReserveByReserveId(searchParam);
        }

        @Override
        public List<String> editing(Long searchParam) {
            return null;
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

    public abstract List<String> editing(Long searchParam);



}
