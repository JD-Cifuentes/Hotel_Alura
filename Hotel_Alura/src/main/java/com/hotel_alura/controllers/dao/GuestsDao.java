package com.hotel_alura.controllers.dao;

import com.hotel_alura.models.Guest;

import javax.persistence.EntityManager;

public class GuestsDao {

    private EntityManager entityManager;

    public GuestsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Guest newGuest){
        this.entityManager.persist(newGuest);
    }

    public Guest readByDocument(long guestDocument){
        String jpql =" SELECT G FROM Guest AS G WHERE G.document=:guestDocument ";
        return entityManager.createQuery(jpql,Guest.class).setParameter("guestDocument", guestDocument).getSingleResult();
    }

    public void update(Guest guest){
        this.entityManager.merge(guest);
    }

    public void delete(Guest guest){
        guest = this.entityManager.merge(guest);
        this.entityManager.remove(guest);
    }



}
