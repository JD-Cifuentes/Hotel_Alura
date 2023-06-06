package com.hotel_alura.testing;

import com.hotel_alura.models.dao.ReserveDao;
import com.hotel_alura.models.Reserve;
import utils.JPAutils;

import javax.persistence.EntityManager;
import java.util.List;

public class SearchReserveListByGuestDocument {
    public static void main(String[] args) {
        List<Reserve> reserveList;

        EntityManager entityManager = JPAutils.getEntityManager();

        ReserveDao reserveDao = new ReserveDao(entityManager);


        entityManager.getTransaction().begin();

        try{
            reserveList = reserveDao.readReserveListByGuestDocument(125344L);

            for (Reserve reserv:
                 reserveList) {
                System.out.println(reserv.getGuest().getName());
            }


        }catch (Exception e){
            System.out.println("reserve wasn't found");
            System.out.println(e);
        }

        entityManager.getTransaction().commit();
    }
}
