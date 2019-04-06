package Services;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public interface iCardService {
    JSONArray searchMinion(String name) throws UnirestException;

    JSONArray searchSpell(String name) throws UnirestException;

    JSONArray getAllCards() throws UnirestException;
}
