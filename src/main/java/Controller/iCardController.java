package Controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

import java.sql.SQLException;

public interface iCardController {
    public String getMinion(String name) throws UnirestException;

    public String getSpell(String spell) throws UnirestException;

    public JSONArray getAllCards() throws UnirestException;

    public void insertMinion(String minion) throws UnirestException;

    public void insertSpell(String spell) throws UnirestException;

    public void exportDB() throws SQLException;
}
