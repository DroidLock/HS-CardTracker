package View;

import Controller.CardController;
import Controller.iCardController;
import Models.Card;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Representing the View of the Project
 */
public class ConsoleApp implements iConsoleApp {

    private iCardController controller = new CardController();
    private Scanner scan = new Scanner(System.in);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String cardName;

    /**
     * @return
     */
    public String mainMenue() throws IOException {
        String selection = "";
        try {
            while (!selection.equals("3")) {
                System.out.println();
                System.out.println("******Hearthstone CardTracker******");
                System.out.println();
                System.out.println("1. Alle Classic Karten anzeigen");
                System.out.println("2. Karte suchen");
                System.out.println("3. Beenden");


                selection = reader.readLine();


                if ("1".equals(selection)) {
                    showAllCards();

                } else if ("2".equals(selection)) {
                    searchMenue();

                } else if ("3".equals(selection)) {
                    stopApp();

                } else {
                    System.out.println("Wählen sie einen Menüpunkt aus");

                }
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     * @throws UnirestException
     */
    public void searchMenue() throws IOException {
        String selection = "";

        while (!selection.equals("4")) {
            System.out.println();
            System.out.println("******Hearthstone SearchMenue******");
            System.out.println();
            System.out.println("1. Minion-Karten suchen");
            System.out.println("2. Spell-Karten suchen");
            System.out.println("3. Zurück zum Hauptmenü");
            System.out.println("4. Beenden");
            selection = reader.readLine();
            if ("1".equals(selection)) {
                searchMinion();

            } else if ("2".equals(selection)) {
                searchSpell();

            } else if ("3".equals(selection)) {
                mainMenue();

            } else if ("4".equals(selection)) {
                stopApp();

            } else {
                System.out.println("Wählen sie einen Menüpunkt aus");
            }
        }
    }

    /**
     * @return
     * @throws UnirestException
     */
    public String showAllCards() throws UnirestException {
        JSONArray all = controller.getAllCards();

        //ToDo Alphabetical order not working, has to be fixed... running now without error, but not sorting
        Arrays.sort(new JSONArray[]{all});

        for (int i = 0; i < all.length(); i++) {
            System.out.printf("%-40s%s%n", "Cardname: " + all.getJSONObject(i).getString("name"),
                    "Cardtype: " + all.getJSONObject(i).getString("type"));
        }
        return null;
    }

    /**
     * @throws IOException
     */
    public void searchMinion() throws IOException {
        System.out.println("Geben sie einen Kartennamen zum suchen ein." + "\t" + "Optionen: zurück und beenden");
        reader = new BufferedReader(new InputStreamReader(System.in));

        //           save user input, removing existing whitespaces and replacing them with %20
        cardName = reader.readLine().replaceAll("\\s", "%20");

        if (cardName.equals("beenden")) {
            stopApp();
        }
        if (cardName.equals("zurück")) {
            mainMenue();
        } else {
            try {
                //Get the Card-Object back which was searched and print out to console
                Card card = controller.getMinion(cardName);
                System.out.println(card.toString());
            } catch (NullPointerException e) {
                System.out.println("Karte konnte nicht gefunden werden ConsoleApp");
//                e.printStackTrace();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Let the user enter a spell card to get details from hearthstone api
     *
     * @return
     * @throws IOException
     */
    public void searchSpell() throws IOException {
        System.out.println("Geben sie einen Kartennamen zum suchen ein." + "\t\t" + "Optionen: zurück und beenden");
        reader = new BufferedReader(new InputStreamReader(System.in));
//        save user input, removing existing whitespaces and replacing them with %20
        cardName = reader.readLine().replaceAll("\\s", "%20");

        if (cardName.equals("beenden")) {
            stopApp();
        }
        if (cardName.equals("zurück")) {
            mainMenue();
        } else {
            try {
                //Get the Card-Object back which was searched and print out to console
                Card card = controller.getSpell(cardName);
                System.out.println(card.toString());
            } catch (NullPointerException e) {
                System.out.println("Karte konnte nicht gefunden werden ConsoleApp");

//                e.printStackTrace();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Shuts down the programm with a goodbye text
     */
    public void stopApp() {
        System.out.println("Danke fürs Benutzes der App");
        System.exit(1);
    }

    /**
     *
     */
    public void saveCard() {
        //Todo create a Mehtod to save card in Database
    }


}