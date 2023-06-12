package com.hotel_alura.controllers.RecordCRUD;

import com.hotel_alura.models.Guest;
import com.hotel_alura.models.Reserve;
import com.hotel_alura.models.dao.GuestsDao;
import com.hotel_alura.models.dao.ReserveDao;
import utils.JPAutils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class RecordCreate {
    public static void createGuest(List<String> dataToCreate, String refForSearch) {
        //todo
        Guest guest;
        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);
        try {
            entityManager.getTransaction().begin();


            entityManager.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("cannot finish operation\n" + e);
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public static void createReserve(List<String> dataToCreate, long document) throws NoSuchFieldException, IllegalAccessException {
        Reserve newReserve = new Reserve(
                LocalDate.parse(dataToCreate.get(0)),
                LocalDate.parse(dataToCreate.get(1)),
                dataToCreate.get(2)
        );

        Guest guestToSearch;

        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestDao = new GuestsDao(entityManager);

        try{
            entityManager.getTransaction().begin();

            guestToSearch = guestDao.readGuestByDocument(document);
            newReserve.setGuest(guestToSearch);
            guestToSearch.addReserve(newReserve);
            guestDao.update(guestToSearch);

            entityManager.getTransaction().commit();

        }catch (Exception e){
            System.out.println("cannot finish operation\n" + e);
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
