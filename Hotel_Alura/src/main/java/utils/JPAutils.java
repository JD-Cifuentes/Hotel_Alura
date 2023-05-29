package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutils {

    private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("HotelAluraDB");
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
