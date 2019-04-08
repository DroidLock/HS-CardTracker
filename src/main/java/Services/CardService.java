package Services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

public class CardService implements iCardService {
    /**
     * @param card
     * @return An array of results from searched minion_card or spell_card
     * @throws UnirestException
     */
    public JSONArray searchCard(String card) throws UnirestException {
        //// TODO: 24/03/2019 exception handling
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards/" + card)
                    .header("X-RapidAPI-Key", "b3e04ebcc2mshe4ccee4fec2e0b2p155f72jsnb66518417065")
                    .asJson();

            JSONArray list = response.getBody().getArray();

            return list;
        } catch (UnirestException e){
            System.out.println("Die Verbindung zur API konnte nicht erstellt werden");
        }
        return null;
    }



    /**
     * request to the hearstone api to get a set of classic cards
     *
     * @return An array of all cards got from request
     * @throws UnirestException
     */
    public JSONArray getAllCards() {

        //// TODO: 24/03/2019 exception handling
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards")
                    .header("X-RapidAPI-Key", "b3e04ebcc2mshe4ccee4fec2e0b2p155f72jsnb66518417065")
                    .asJson();

            JSONArray list = response.getBody().getObject().getJSONArray("Classic");

//      System.out.println(list.toString());
            return list;
        }  catch (UnirestException e) {
            System.out.println("Die Verbindung zur API konnte nicht hergestellt werden");
        }
        return null;
    }
}
