package Services;

import Models.Minion;
import Models.Spell;

import java.sql.SQLException;

public interface iDBService {
    public void saveMinion(Minion minion) throws SQLException;
    public void saveSpell(Spell spell);
}
