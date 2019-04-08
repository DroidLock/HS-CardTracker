package Repository;

import Models.Card;

import java.sql.SQLException;

public interface iCardRepository{
    void saveCard(Card selectedCard) throws SQLException;
}
