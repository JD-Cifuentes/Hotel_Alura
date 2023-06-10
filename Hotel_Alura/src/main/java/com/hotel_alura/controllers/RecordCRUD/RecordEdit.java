package com.hotel_alura.controllers.updates;

import com.hotel_alura.models.Guest;
import com.hotel_alura.models.Reserve;
import com.hotel_alura.models.dao.GuestsDao;
import com.hotel_alura.models.dao.ReserveDao;
import com.hotel_alura.models.enums.PaymentMethods;
import utils.JPAutils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class RecordEdit {

    //todo implementar los métodos que editaran los campos en la base de datos
    public void updateGuestByDocument(List<String> dataToUpdate, String refForSearch) {
        Guest guest = new Guest();
        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);

        try {
            entityManager.getTransaction().begin();

            guest = guestsDao.readGuestByDocument(Long.parseLong(refForSearch));

            guest.setName((String) dataToUpdate.get(0));
            guest.setLastName((String) dataToUpdate.get(1));
            guest.setBirthDate(LocalDate.parse(dataToUpdate.get(2)) );
            guest.setNationality((String) dataToUpdate.get(3));
            guest.setTelephoneNum( Long.parseLong(dataToUpdate.get(4))  );

            guestsDao.update(guest);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("cannot finish operation\n" + e);
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public void updateReserveByReserveId(List<String> dataToUpdate, String refForSearch){
        Reserve reserve = new Reserve();
        EntityManager entityManager = JPAutils.getEntityManager();
        ReserveDao reserveDao = new ReserveDao(entityManager);

        try{
            entityManager.getTransaction().begin();

            reserve = reserveDao.readOneReserveByReserveId(Long.parseLong(refForSearch));

            reserve.setCheckIn(LocalDate.parse(dataToUpdate.get(0)));
            reserve.setCheckOut(LocalDate.parse(dataToUpdate.get(1)));
            reserve.setPrice(Double.parseDouble(dataToUpdate.get(2)));
            reserve.setPaymentMethod(dataToUpdate.get(3));

            reserveDao.update(reserve);

            System.out.println(reserve);

            entityManager.getTransaction().commit();

        }catch (Exception e){
            System.out.println("cannot finish operation\n" + e);
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

}
