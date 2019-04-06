package Services;

import Models.Minion;
import Models.Spell;

import java.sql.SQLException;

public interface iDBService {
    void saveMinion(Minion minion) throws SQLException;

    void saveSpell(Spell spell) throws SQLException;
}
