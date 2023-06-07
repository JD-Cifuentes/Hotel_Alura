package com.hotel_alura.controllers.readers;

import com.hotel_alura.models.Guest;
import com.hotel_alura.models.Reserve;
import com.hotel_alura.models.dao.GuestsDao;
import com.hotel_alura.models.dao.ReserveDao;
import utils.JPAutils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecordSearch {
    public List<String> searchGuestByDocument(long searchDocumentParam){
        Guest guest = new Guest();
        List<String> guestReservesRegister = new ArrayList<>();
        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);

        entityManager.getTransaction().begin();
        try{
            guest = guestsDao.readGuestByDocument(searchDocumentParam);
        }catch (Exception e){
            System.out.println("guest wasn't found\n" + e);
        }
        entityManager.getTransaction().commit();

        if (guest != null){
            guest.getReservesList().sort(Comparator.comparing(Reserve::getCheckIn).reversed());
            String reserveDataRow;
            for (Reserve reserve:
                    guest.getReservesList()) {
                reserveDataRow =guest.getDocument() + "\n" +
                                guest.getName() + "\n" +
                                guest.getLastName() + "\n" +
                                guest.getBirthDate() + "\n" +
                                guest.getNationality() + "\n" +
                                guest.getTelephoneNum() + "\n" +
                                reserve.getId();
                guestReservesRegister.add(reserveDataRow);
            }
        }
        return guestReservesRegister;
    }

    public List<String> searchReserveByReserveId(long searchIdParam){
        Reserve reserve = new Reserve();
        List<String> reservesRegister = new ArrayList<>();
        EntityManager entityManager = JPAutils.getEntityManager();
        ReserveDao reserveDao = new ReserveDao(entityManager);

        entityManager.getTransaction().begin();

        try{
            reserve = reserveDao.readOneReserveByReserveId(searchIdParam);
        }catch (Exception e){
            System.out.println("reserve wasn't found\n" + e);
        }

        entityManager.getTransaction().commit();

        if (reserve.getRegisterDate() != null){
            String reserveDataRow =
                    reserve.getId() + "\n" +
                    reserve.getRegisterDate() + "\n" +
                    reserve.getCheckIn() + "\n" +
                    reserve.getCheckOut() + "\n" +
                    reserve.getPrice() + "\n" +
                    reserve.getPaymentMethod();
            reservesRegister.add(reserveDataRow);
        }

        return reservesRegister;
    }



}
