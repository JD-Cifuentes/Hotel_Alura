package com.hotel_alura.views.components_instancy_tools;

import com.hotel_alura.models.ComboBoxKeyValue;
import com.hotel_alura.models.enums.JsonMaps;

import javax.swing.JComboBox;


public class InitComboBoxes {
    private JComboBox jBox;
    public InitComboBoxes(JComboBox jBox, JsonMaps mapToRead) {
        this.jBox = jBox;

        for (ComboBoxKeyValue entry : mapToRead.getJsonList()) {
            this.jBox.addItem(entry.getNationality());
        }

    }
}
