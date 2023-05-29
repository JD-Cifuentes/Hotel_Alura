package com.hotel_alura.controllers.dao;

import com.hotel_alura.models.Guest;
import com.hotel_alura.models.Reserve;

import javax.persistence.EntityManager;
import java.util.List;

public class ReserveDao {


    private EntityManager entityManager;

    public ReserveDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Reserve> readByGuest(Guest guestReserves){
        String jpql =" SELECT R FROM Reserve AS R WHERE R.guest=:guestReserves ";
        return entityManager.createQuery(jpql,Reserve.class).setParameter("guestReserves", guestReserves).getResultList();
    }

    public void deleteReserve(long reserveId){
        String jpql =" DELETE FROM Reserve WHERE id =: reserveId ";
        entityManager.createQuery(jpql).setParameter("reserveId", reserveId).executeUpdate();

    }

}
