package com.hotel_alura.testing;

import com.hotel_alura.controllers.dao.GuestsDao;
import com.hotel_alura.models.Guest;
import utils.JPAutils;

import javax.persistence.EntityManager;

public class DeletingGuest {
    public static void main(String[] args) {

        Guest guestToSearch = new Guest();
        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);



        entityManager.getTransaction().begin();

        guestToSearch = guestsDao.readByDocument(125344L);
        guestsDao.deleteGuest(guestToSearch);

        entityManager.getTransaction().commit();

    }

}
