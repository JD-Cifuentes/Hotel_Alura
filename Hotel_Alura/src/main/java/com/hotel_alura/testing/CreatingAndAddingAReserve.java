package com.hotel_alura.testing;

import com.hotel_alura.controllers.dao.GuestsDao;
import com.hotel_alura.controllers.dao.ReserveDao;
import com.hotel_alura.models.Guest;
import com.hotel_alura.models.PaymentMethods;
import com.hotel_alura.models.Reserve;
import utils.JPAutils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class CreatingAndAddingAReserve {
    public static void main(String[] args) {

        Guest guestToSearch = new Guest();

        LocalDate checkInDate = LocalDate.of(2023,12,25);
        Reserve newReserve = new Reserve(checkInDate, checkInDate.plusDays(4),4*10000, PaymentMethods.CASH);
        EntityManager entityManager = JPAutils.getEntityManager();

        GuestsDao guestsDao = new GuestsDao(entityManager);
        ReserveDao reserveDao = new ReserveDao(entityManager);



        entityManager.getTransaction().begin();

        guestToSearch = guestsDao.readByDocument(125344L);
        newReserve.setGuest(guestToSearch);
        guestToSearch.addReserve(newReserve);
        guestsDao.update(guestToSearch);

        entityManager.getTransaction().commit();

    }
}
