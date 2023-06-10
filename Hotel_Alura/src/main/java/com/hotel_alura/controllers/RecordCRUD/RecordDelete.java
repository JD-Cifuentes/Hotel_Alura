package com.hotel_alura.controllers.RecordCRUD;

import com.hotel_alura.models.Guest;
import com.hotel_alura.models.Reserve;
import com.hotel_alura.models.dao.GuestsDao;
import com.hotel_alura.models.dao.ReserveDao;
import utils.JPAutils;

import javax.persistence.EntityManager;


public class RecordDelete {

    public static void deleteGuestByDocument(String refToDelete){
        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);
        entityManager.getTransaction().begin();

        guestsDao.deleteGuestByDocument(Long.parseLong(refToDelete));

        entityManager.getTransaction().commit();

    }

    public static void deleteReserveById(String refToDelete){
        EntityManager entityManager = JPAutils.getEntityManager();
        ReserveDao reserveDao = new ReserveDao(entityManager);
        entityManager.getTransaction().begin();

        reserveDao.deleteReserveById(Long.parseLong(refToDelete));

        entityManager.getTransaction().commit();


    }
}
