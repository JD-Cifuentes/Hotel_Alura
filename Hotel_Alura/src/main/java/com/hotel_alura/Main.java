package com.hotel_alura;


import com.hotel_alura.views.MenuPrincipal;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        MenuPrincipal pm = new MenuPrincipal();
        pm.setTitle("Hotel Alura");
        pm.setVisible(true);
        centreWindow(pm);
        pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public static void centreWindow(MenuPrincipal frame ) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

}