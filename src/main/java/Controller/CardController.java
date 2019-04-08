package Controller;


import Models.Card;
import Models.Minion;
import Models.Spell;
import Services.CardService;
import Services.DBService;
import Services.iCardService;
import Services.iDBService;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;

import java.sql.SQLException;

public class CardController implements iCardController {

    private iCardService service = new CardService();
    private iDBService dataservice = new DBService();
    private Gson gson = new Gson();

    /**
     * Method calls service to get a single spell card and deserialize JSONArray the returns
     *
     * @param userInput userinput from ConosoleApp(View)
     * @return a minion object to the view
     * @throws UnirestException gets thrown when JSON cant be converted because of missing or wrong datafile
     */
    public String getMinion(String userInput) throws UnirestException {

        // Get Array back from API service
        JSONArray cardResponse = service.searchMinion(userInput);
        String json = cardResponse.getJSONObject(0).toString();
//        Output to check whole json
//        System.out.println(cardResponse.toString());

        try {
            Minion minion = gson.fromJson(json, Minion.class);//
            return minion.toString();
        } catch (JSONException e) {
//             exception thrown when json could not be read properly and is needed so a NullPointerException can be thrown/caught in view ConsoleApp
//            System.out.println("Json exception Controller");
//            e.printStackTrace();
        } catch (JsonIOException e){
            System.out.println("Daten konnten von der API nicht gelesen werden");
        } catch (JsonParseException e){
            System.out.println("Json Datei konnte nicht geparst werden");
        }
        return null;
    }


    /**
     * Method calls service to get a single spell card and deserialize JSONArray to a object
     *
     * @param userInput from ConosoleApp(View)
     * @return a spell object to the view or null on fail of the request
     * @throws UnirestException
     */
    public String getSpell(String userInput) throws UnirestException {

        JSONArray cardResponse = service.searchMinion(userInput);
        String json = cardResponse.getJSONObject(0).toString();
        try {
            Card spell = gson.fromJson(json, Spell.class);
            return spell.toString();

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
            String type = cardResponse.getJSONObject(0).getString("type");
            String text = cardResponse.getJSONObject(0).getString("text");
            String rarity = cardResponse.getJSONObject(0).getString("rarity");
            String image = cardResponse.getJSONObject(0).getString("imgGold");
            int attack = cardResponse.getJSONObject(0).getInt("attack");
            int health = cardResponse.getJSONObject(0).getInt("health");

            Card minionDB = new Minion(name,cost,type,text,image,attack,health,rarity);
            System.out.println(minionDB.toString());
            dataservice.saveCard(minionDB);
        } catch (JSONException e) {
//             exception thrown when json could not be read properly and is needed so a NullPointerException can be thrown/caught in view ConsoleApp
//            System.out.println("Json exception Controller");
//            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSpell(String spell) throws UnirestException {
        JSONArray cardResponse = service.searchSpell(spell);

        try {
            String name = cardResponse.getJSONObject(0).getString("name");
            int cost = cardResponse.getJSONObject(0).getInt("cost");
            String type = cardResponse.getJSONObject(0).getString("type");
            String text = cardResponse.getJSONObject(0).getString("text");
            String image = cardResponse.getJSONObject(0).getString("imgGold");

            Card spellDB = new Spell(name, cost, type, text, image);
            dataservice.saveCard(spellDB);
        } catch (JSONException e) {
//             exception thrown when json could not be read properly and is needed so a NullPointerException can be thrown/caught in view ConsoleApp
//            System.out.println("Json exception Controller");
//            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
