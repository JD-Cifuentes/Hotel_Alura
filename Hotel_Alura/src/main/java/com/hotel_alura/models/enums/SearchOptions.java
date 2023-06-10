package com.hotel_alura.models.enums;

import com.hotel_alura.controllers.RecordCRUD.RecordDelete;
import com.hotel_alura.controllers.RecordCRUD.RecordEdit;
import com.hotel_alura.controllers.RecordCRUD.RecordSearch;

import java.util.List;

public enum SearchOptions {
    GUEST("Huéspedes") {
        @Override
        public List<String> searching(Long searchParam) {
            return RecordSearch.searchGuestByDocument(searchParam);
        }
        @Override
        public void editing(List<String> dataToUpdate, String refForSearch) {
            RecordEdit.updateGuestByDocument(dataToUpdate, refForSearch);
        }

        @Override
        public void deleting(String refToDelete) {
            RecordDelete.deleteGuestByDocument(refToDelete);
        }
    },
    RESERVE("Reservas") {
        @Override
        public List<String> searching(Long searchParam) {
            return RecordSearch.searchReserveByReserveId(searchParam);
        }
        @Override
        public void editing(List<String> dataToUpdate, String refForSearch) {
            RecordEdit.updateReserveByReserveId(dataToUpdate, refForSearch);
        }

        @Override
        public void deleting(String refToDelete) {
            RecordDelete.deleteReserveById(refToDelete);
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

    public abstract void deleting(String refToDelete);


}


