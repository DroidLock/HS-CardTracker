package Repository;

import Models.Minion;
import Models.Spell;
import utilities.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardRepository implements iCardRepository {


    /**
     * @param minion
     * @throws SQLException
     */
    public void saveMinion(Minion minion) throws SQLException {
        PreparedStatement ps = null;
        String insertTableSQL = "INSERT INTO deck"
                + "(name, cost, attack, health, type, text, rarity, image) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DBConnection.getInstance();
            ps = conn.prepareStatement(insertTableSQL);
            ps.setString(1, minion.getName());
            ps.setInt(2, minion.getCost());
            ps.setInt(3, minion.getAttack());
            ps.setInt(4, minion.getHealth());
            ps.setString(5, minion.getType());
            ps.setString(6, minion.getText());
            ps.setString(7, minion.getRarity());
            ps.setString(8, minion.getImgGold());

            ps.executeUpdate();

            System.out.println("Minion erfolgreich in der Datenbank gespeichert");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Speicherung in die Datenbank");
//            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * @param spell
     * @throws SQLException
     */
    public void saveSpell(Spell spell) throws SQLException {
        //// TODO: 23/03/2019  implementation of saving spell in database
    }
}
