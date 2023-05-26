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

    public void create(Reserve newReserve){
        this.entityManager.persist(newReserve);
    }

    public List<Reserve> readByGuest(Guest guestReserves){
        String jpql =" SELECT R FROM Reserve AS R WHERE R.guests=:guestReserves ";
        return entityManager.createQuery(jpql,Reserve.class).setParameter("guestReserves", guestReserves).getResultList();
    }

    public void update(Reserve reserve){
        this.entityManager.merge(reserve);
    }

    public void delete(Reserve reserve){
        reserve = this.entityManager.merge(reserve);
        this.entityManager.remove(reserve);
    }

}
