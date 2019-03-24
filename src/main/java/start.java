
import Controller.CardController;
import Controller.iCardController;
import Models.Card;
import View.ConsoleApp;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.Scanner;


public class start {
    public static void main(String[] args) throws UnirestException, IOException {

        ConsoleApp app = new ConsoleApp();
        app.mainMenue();



//        System.out.println(att);

//        HttpResponse<JsonNode> response = Unirest.get("https://api.nasa.gov/neo/rest/v1/neo/sentry?is_active=true&page=0&size=50&api_key=tOoehoxuPKGgOVnxwURGuXFSY4QenbtILR9ERzxL")
//                .asJson();
//
//        String asteroidsList = response.getBody().toString();
//        System.out.println(asteroidsList);

    }
}

