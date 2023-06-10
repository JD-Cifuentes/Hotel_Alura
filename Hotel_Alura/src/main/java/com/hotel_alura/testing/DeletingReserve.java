package com.hotel_alura.testing;

import com.hotel_alura.models.dao.GuestsDao;
import com.hotel_alura.models.dao.ReserveDao;
import com.hotel_alura.models.Guest;
import com.hotel_alura.models.Reserve;
import utils.JPAutils;

import javax.persistence.EntityManager;

public class DeletingReserve {
    public static void main(String[] args) {
        Guest guestToSearch = new Guest();
        Reserve reserve = new Reserve();

        EntityManager entityManager = JPAutils.getEntityManager();
        GuestsDao guestsDao = new GuestsDao(entityManager);
        ReserveDao reserveDao = new ReserveDao(entityManager);


        entityManager.getTransaction().begin();

        guestToSearch = guestsDao.readGuestByDocument(125344L);

        reserve = guestToSearch.getReserve(2);

        try{
            reserveDao.deleteReserveById(reserve.getId());

        }catch (Exception e){
            System.out.println("reserve wasn't found");
            System.out.println(e);
        }

        entityManager.getTransaction().commit();
    }
}
