package com.hotel_alura;

import com.hotel_alura.controllers.dao.GuestsDao;
import com.hotel_alura.controllers.dao.ReserveDao;
import com.hotel_alura.models.Guest;
import com.hotel_alura.models.PaymentMethods;
import com.hotel_alura.models.Reserve;
import com.hotel_alura.views.MenuPrincipal;
import net.bytebuddy.asm.Advice;
import utils.JPAutils;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        /*MenuPrincipal pm = new MenuPrincipal();
        pm.setTitle("Conversor Alura");
        pm.setVisible(true);
        centreWindow(pm);
        pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/


        //todo add search by reserve id, which will be the reserve number



        Guest guestToSearch = new Guest();
        Reserve reserve = new Reserve();

        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);
        ReserveDao reserveDao = new ReserveDao(entityManager);


        entityManager.getTransaction().begin();

        guestToSearch = guestsDao.readByDocument(125344L);

        reserve = guestToSearch.getReserve(2);

        try{
            reserveDao.deleteReserve(reserve.getId());

        }catch (Exception e){
            System.out.println("reserve wasn't found");
            System.out.println(e);
        }

        entityManager.getTransaction().commit();



    }
    /*public static void centreWindow(MenuPrincipal frame ) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }*/

}