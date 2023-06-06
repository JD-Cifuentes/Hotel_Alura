package com.hotel_alura.testing;

import com.hotel_alura.models.dao.ReserveDao;
import com.hotel_alura.models.Reserve;
import utils.JPAutils;

import javax.persistence.EntityManager;

public class SearchReserveByReserveId {
    public static void main(String[] args) {

        Reserve reserve;

        EntityManager entityManager = JPAutils.getEntityManager();

        ReserveDao reserveDao = new ReserveDao(entityManager);


        entityManager.getTransaction().begin();

        try{
            reserve = reserveDao.readOneReserveByReserveId(5);

            System.out.println(reserve.getGuest().getName());

        }catch (Exception e){
            System.out.println("reserve wasn't found");
            System.out.println(e);
        }

        entityManager.getTransaction().commit();
    }
}
