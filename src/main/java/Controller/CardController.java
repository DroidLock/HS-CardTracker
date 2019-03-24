package Controller;

import Models.Card;
import Services.CardService;
import Services.iCardService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;

public class CardController implements iCardController {

    private iCardService service = new CardService();

    /**
     * @param selected userinput from ConosoleApp(View)
     * @return Created Card from api service request
     * @throws UnirestException gets thrown when JSON cant be converted because of missing or wrong datafile
     */
    public Card getMinion(String selected) throws UnirestException {

//        Check user input
//        System.out.println(selected);

        // Get Array back from API service
        JSONArray cardResponse = service.searchMinion(selected);

//        Output to check whole json
//        System.out.println(cardResponse.toString());

        try {
            String name = cardResponse.getJSONObject(0).getString("name");
            int cost = cardResponse.getJSONObject(0).getInt("cost");
            int attack = cardResponse.getJSONObject(0).getInt("attack");
            int health = cardResponse.getJSONObject(0).getInt("health");
            String type = cardResponse.getJSONObject(0).getString("type");
            String text = cardResponse.getJSONObject(0).getString("text");
            String rarity = cardResponse.getJSONObject(0).getString("rarity");
            String image = cardResponse.getJSONObject(0).getString("imgGold");

            return new Card(name, cost, attack, health, type, text, rarity, image);

        } catch (JSONException e) {
//             exception thrown when json could not be read properly and is needed so a NullPointerException can be thrown/caught in view ConsoleApp
//            System.out.println("Json exception Controller");
//            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param spell
     * @return
     * @throws UnirestException
     */
    public Card getSpell(String spell) throws UnirestException {
        JSONArray cardResponse = service.searchMinion(spell);
        try {
            String name = cardResponse.getJSONObject(0).getString("name");
            int cost = cardResponse.getJSONObject(0).getInt("cost");
            String type = cardResponse.getJSONObject(0).getString("type");
            String text = cardResponse.getJSONObject(0).getString("text");
            String image = cardResponse.getJSONObject(0).getString("imgGold");


            return new Card(name, cost, type, text, image);

        } catch (JSONException e) {
//            exception thrown when json could not be read properly and is needed so a NullPointerException can be thrown/caught in view ConsoleApp
//            System.out.println("Json exception Controller");
//            e.printStackTrace();
        }

        return null;
    }

    /**
     * @return Array of all cards gathered from api service request
     * @throws UnirestException gets thrown when JSON cant be converted because of missing or wrong datafile
     */
    public JSONArray getAllCards() throws UnirestException {
        JSONArray result = service.getAllCards();
        return result;
    }

}
