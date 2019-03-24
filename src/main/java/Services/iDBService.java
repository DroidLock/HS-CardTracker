package Services;

import Models.Minion;
import Models.Spell;

public interface iDBService {
    public void saveMinion(Minion minion);
    public void saveSpell(Spell spell);
}
