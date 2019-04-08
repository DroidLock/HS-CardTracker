package Services;

import Models.Card;
import Repository.CardRepository;
import Repository.iCardRepository;

import java.sql.SQLException;

public class DBService implements iDBService {

    iCardRepository repo = new CardRepository();
    /**
     * @param card
     */
    public void saveCard(Card card) throws SQLException{
        repo.saveCard(card);
    }
}
