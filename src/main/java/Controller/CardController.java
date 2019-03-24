package Controller;


import Models.Minion;
import Models.Spell;
import Services.CardService;
import Services.DBService;
import Services.iCardService;
import Services.iDBService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;

public class CardController implements iCardController {

    private iCardService service = new CardService();
    private iDBService dataservice = new DBService();

    /**
     *
     * Method calls service to get a single spell card and deserialize JSONArray the returns
     *
     * @param userInput userinput from ConosoleApp(View)
     * @return a minion object to the view
     * @throws UnirestException gets thrown when JSON cant be converted because of missing or wrong datafile
     */
    public String getMinion(String userInput) throws UnirestException {

//        Check user input
//        System.out.println(userInput);

        // Get Array back from API service
        JSONArray cardResponse = service.searchMinion(userInput);

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

            return new Minion(name, cost, attack, health, type, text, rarity, image).toString();

        } catch (JSONException e) {
//             exception thrown when json could not be read properly and is needed so a NullPointerException can be thrown/caught in view ConsoleApp
//            System.out.println("Json exception Controller");
//            e.printStackTrace();
        }
        return null;
    }


    /**
     * Method calls service to get a single spell card and deserialize JSONArray to a object
     *
     * @param userInput from ConosoleApp(View)
     * @return  a spell object to the view or null on fail of the request
     * @throws UnirestException
     */
    public String getSpell(String userInput) throws UnirestException {
        JSONArray cardResponse = service.searchMinion(userInput);
        try {
            String name = cardResponse.getJSONObject(0).getString("name");
            int cost = cardResponse.getJSONObject(0).getInt("cost");
            String type = cardResponse.getJSONObject(0).getString("type");
            String text = cardResponse.getJSONObject(0).getString("text");
            String image = cardResponse.getJSONObject(0).getString("imgGold");


            return new Spell(name, cost, type, text, image).toString();

        } catch (JSONException e) {
//            exception thrown when json could not be read properly and is needed so a NullPointerException can be thrown/caught in view ConsoleApp
//            System.out.println("Json exception Controller");
//            e.printStackTrace();
        }
        return null;
    }

    /**
     * Ask the service to get all classic cards
     *
     * @return Array of all cards gathered from api service request
     * @throws UnirestException gets thrown when JSON cant be converted because of missing or wrong datafile
     */
    public JSONArray getAllCards() throws UnirestException {
        //// TODO: 24/03/2019 exception handling
        JSONArray result = service.getAllCards();
        return result;
    }

    public void insertMinion(String minion) throws UnirestException {
        JSONArray cardResponse = service.searchMinion(minion);

            try {
                String name = cardResponse.getJSONObject(0).getString("name");
                int cost = cardResponse.getJSONObject(0).getInt("cost");
                int attack = cardResponse.getJSONObject(0).getInt("attack");
                int health = cardResponse.getJSONObject(0).getInt("health");
            String type = cardResponse.getJSONObject(0).getString("type");
            String text = cardResponse.getJSONObject(0).getString("text");
            String rarity = cardResponse.getJSONObject(0).getString("rarity");
            String image = cardResponse.getJSONObject(0).getString("imgGold");

            Minion minionDB =  new Minion(name, cost, attack, health, type, text, rarity, image);
            dataservice.saveMinion(minionDB);
        } catch (JSONException e) {
//             exception thrown when json could not be read properly and is needed so a NullPointerException can be thrown/caught in view ConsoleApp
//            System.out.println("Json exception Controller");
//            e.printStackTrace();
        }

    }
}
