package Services;

import Models.Minion;
import Models.Spell;
import Repository.CardRepository;
import Repository.iCardRepository;

import java.sql.SQLException;

public class DBService implements iDBService {

    iCardRepository repo = new CardRepository();

    /**
     * @param minion
     * @throws SQLException
     */
    public void saveMinion(Minion minion) throws SQLException {
        repo.saveMinion(minion);
    }


    public void saveSpell(Spell spell) throws SQLException {
        //// TODO: 24/03/2019 finish code for inserting spell into the database
        repo.saveSpell(spell);
    }
}
