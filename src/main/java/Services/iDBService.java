package Services;

import Models.Card;

import java.sql.SQLException;

public interface iDBService {

    void saveCard(Card card);

    void exportDeck() throws SQLException;
}
