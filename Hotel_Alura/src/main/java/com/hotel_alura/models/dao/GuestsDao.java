package com.hotel_alura.models.dao;

import com.hotel_alura.models.Guest;

import javax.persistence.EntityManager;

public class GuestsDao {

    private final EntityManager entityManager;

    public GuestsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Guest newGuest){
        this.entityManager.persist(newGuest);
    }

    public Guest readGuestByDocument(long guestDocument){
        String jpql =" SELECT G FROM Guest AS G WHERE G.document=:guestDocument ";
        return entityManager.createQuery(jpql,Guest.class).setParameter("guestDocument", guestDocument).getSingleResult();
    }

    public long verifyGuestExistenceByDocument(long guestDocument){
        String jpql =" SELECT COUNT(G) FROM Guest G WHERE G.document = :guestDocument ";
        return  entityManager.createQuery(jpql,Long.class).setParameter("guestDocument", guestDocument).getSingleResult();
    }

    public void update(Guest guest){
        this.entityManager.merge(guest);
    }

    public void deleteGuestByDocument(long GuestDoc){
        String jpql =" DELETE FROM Guest WHERE id =: GuestDoc ";
        entityManager.createQuery(jpql).setParameter("GuestDoc", GuestDoc).executeUpdate();

    }

}
