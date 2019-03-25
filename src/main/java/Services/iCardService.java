package Services;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public interface iCardService {
    public JSONArray searchMinion(String name) throws UnirestException;

    public JSONArray searchSpell(String name) throws UnirestException;

    public JSONArray getAllCards() throws UnirestException;
}
