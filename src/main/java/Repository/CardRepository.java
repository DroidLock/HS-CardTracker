package Repository;

import Models.Card;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class CardRepository implements iCardRepository {


    /**
     * @param selected
     * @throws SQLException
     */
    public void saveCard(Card selected) {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("hearthstone");

        EntityManager entityManager = emfactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(selected);
        entityManager.getTransaction().commit();
        entityManager.close();
        emfactory.close();

    }

}
