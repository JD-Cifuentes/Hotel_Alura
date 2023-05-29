package com.hotel_alura.testing;

import com.hotel_alura.controllers.dao.GuestsDao;
import com.hotel_alura.controllers.dao.ReserveDao;
import com.hotel_alura.models.Guest;
import com.hotel_alura.models.PaymentMethods;
import com.hotel_alura.models.Reserve;
import utils.JPAutils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class SearchingAndUpdatingGuest {
    public static void main(String[] args) {

        Guest guestToSearch = new Guest();
        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);


        entityManager.getTransaction().begin();

        guestToSearch = guestsDao.readByDocument(125344L);
        guestToSearch.setBirthDate(LocalDate.of(2001,12,25));
        guestsDao.update(guestToSearch);

        entityManager.getTransaction().commit();

    }
}
