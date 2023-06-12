package com.hotel_alura.testing;

import com.hotel_alura.models.dao.GuestsDao;
import com.hotel_alura.models.dao.ReserveDao;
import com.hotel_alura.models.Guest;
import com.hotel_alura.models.enums.PaymentMethods;
import com.hotel_alura.models.Reserve;
import utils.JPAutils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class CreatingAndAddingAReserve {
    public static void main(String[] args) {

        Guest guestToSearch = new Guest();

        LocalDate checkInDate = LocalDate.of(2021,6,2);
        Reserve newReserve = null;
        try {
            newReserve = new Reserve(checkInDate, checkInDate.plusDays(4), PaymentMethods.CASH.toString());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        EntityManager entityManager = JPAutils.getEntityManager();

        GuestsDao guestsDao = new GuestsDao(entityManager);
        ReserveDao reserveDao = new ReserveDao(entityManager);



        entityManager.getTransaction().begin();

        guestToSearch = guestsDao.readGuestByDocument(125344L);
        newReserve.setGuest(guestToSearch);
        guestToSearch.addReserve(newReserve);
        guestsDao.update(guestToSearch);

        entityManager.getTransaction().commit();

    }
}
