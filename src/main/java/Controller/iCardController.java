package Controller;

import Models.Minion;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public interface iCardController {
    public String getMinion(String name) throws UnirestException;
    public String getSpell(String spell) throws UnirestException;
    public JSONArray getAllCards() throws UnirestException;
    public void insertMinion(String minion) throws UnirestException;
}
