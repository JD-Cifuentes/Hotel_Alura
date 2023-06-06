package com.hotel_alura.models.dao;

import com.hotel_alura.models.Guest;
import com.hotel_alura.models.Reserve;

import javax.persistence.EntityManager;
import java.util.List;

public class ReserveDao {


    private EntityManager entityManager;

    public ReserveDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Reserve> readReserveListByGuestDocument(long guestDocument){
        String jpql =" SELECT R FROM Reserve R JOIN R.guest G WHERE G.document = :guestDocument ";
        return entityManager.createQuery(jpql,Reserve.class).setParameter("guestDocument", guestDocument).getResultList();
    }

    public Reserve readOneReserveByReserveId(long reserveId){
        String jpql =" SELECT R FROM Reserve AS R WHERE R.id=:reserveId ";
        return entityManager.createQuery(jpql,Reserve.class).setParameter("reserveId", reserveId).getSingleResult();
    }

    public void deleteReserve(long reserveId){
        String jpql =" DELETE FROM Reserve WHERE id =: reserveId ";
        entityManager.createQuery(jpql).setParameter("reserveId", reserveId).executeUpdate();

    }

}
