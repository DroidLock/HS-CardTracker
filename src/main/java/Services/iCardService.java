package Services;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public interface iCardService {
    JSONArray searchCard(String name) throws UnirestException;

//    JSONArray searchSpell(String name) throws UnirestException;

    JSONArray getAllCards() throws UnirestException;
}
