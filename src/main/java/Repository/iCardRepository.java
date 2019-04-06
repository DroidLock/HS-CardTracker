package Repository;

import Models.Minion;
import Models.Spell;

import java.sql.SQLException;

public interface iCardRepository {
    public void saveMinion (Minion minion) throws SQLException;
    public void saveSpell (Spell spell) throws SQLException;
}
