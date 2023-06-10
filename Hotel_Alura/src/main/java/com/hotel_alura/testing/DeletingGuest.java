package com.hotel_alura.testing;

import com.hotel_alura.models.dao.GuestsDao;
import com.hotel_alura.models.Guest;
import utils.JPAutils;

import javax.persistence.EntityManager;

public class DeletingGuest {
    public static void main(String[] args) {

        Guest guestToSearch;
        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);

        entityManager.getTransaction().begin();

        guestToSearch = guestsDao.readGuestByDocument(125344L);
        guestsDao.deleteGuestByDocument(125344L);

        entityManager.getTransaction().commit();

    }

}
