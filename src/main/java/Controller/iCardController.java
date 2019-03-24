package Controller;

import Models.Card;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public interface iCardController {
    public Card getMinion(String name) throws UnirestException;
    public Card getSpell(String spell) throws UnirestException;
    public JSONArray getAllCards() throws UnirestException;
}
