package Services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public class CardService implements iCardService {
    /**
     * @param minion
     * @return An array of results from searched minion_card
     * @throws UnirestException
     */
    public JSONArray searchMinion(String minion) throws UnirestException {
        //// TODO: 24/03/2019 exception handling
        HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards/" + minion)
                .header("X-RapidAPI-Key", "b3e04ebcc2mshe4ccee4fec2e0b2p155f72jsnb66518417065")
                .asJson();

        JSONArray list = response.getBody().getArray();

        return list;
    }

    public JSONArray searchSpell(String spell) throws UnirestException {
        //// TODO: 24/03/2019 exception handling
        HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards/" + spell)
                .header("X-RapidAPI-Key", "b3e04ebcc2mshe4ccee4fec2e0b2p155f72jsnb66518417065")
                .asJson();

        JSONArray list = response.getBody().getArray();

        return list;
    }

    /**
     * request to the hearstone api to get a set of classic cards
     *
     * @return An array of all cards got from request
     * @throws UnirestException
     */
    public JSONArray getAllCards() throws UnirestException {

        //// TODO: 24/03/2019 exception handling

        HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards")
                .header("X-RapidAPI-Key", "b3e04ebcc2mshe4ccee4fec2e0b2p155f72jsnb66518417065")
                .asJson();

        JSONArray list = response.getBody().getObject().getJSONArray("Classic");

//      System.out.println(list.toString());
        return list;
    }
}
