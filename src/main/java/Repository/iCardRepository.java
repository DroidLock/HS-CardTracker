package Repository;

import Models.Card;

import java.sql.SQLException;
import java.util.List;

public interface iCardRepository{
    void saveCard(Card selectedCard) throws SQLException;
    List<Card> getDeck() throws SQLException;
}
