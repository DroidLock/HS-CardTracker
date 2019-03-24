package Services;

import Models.Minion;
import Models.Spell;
import utilities.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBService implements iDBService {
    public void saveMinion(Minion minion) {

        String insertTableSQL = "INSERT INTO minion"
                + "(name, cost, attack, health, type, text, rarity, image) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection conn = DBConnection.getInstance();
            PreparedStatement ps = conn.prepareStatement(insertTableSQL);
            ps.setString(1,minion.getName());
            ps.setInt(2, minion.getCost());
            ps.setInt(3, minion.getAttack());
            ps.setInt(4, minion.getHealth());
            ps.setString(5, minion.getType());
            ps.setString(6, minion.getText());
            ps.setString(7, minion.getRarity());
            ps.setString(8, minion.getImage());

            ps.executeUpdate();
            System.out.println("Minion erfolgreich in der Datenbank gespeichert");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveSpell(Spell spell) {

    }
}
