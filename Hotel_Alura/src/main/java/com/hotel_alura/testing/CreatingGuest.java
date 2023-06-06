package com.hotel_alura.testing;

import com.hotel_alura.models.dao.GuestsDao;
import com.hotel_alura.models.Guest;
import utils.JPAutils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class CreatingGuest {
    public static void main(String[] args) {

        Guest guest_1 = new Guest(125344, "Vash", "Stampede", LocalDate.of(1990,12,25), "Colombia", 3165234987L);
        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);


        entityManager.getTransaction().begin();
        guestsDao.create(guest_1);
        entityManager.getTransaction().commit();

    }
}
