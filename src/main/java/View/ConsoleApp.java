package View;

import Controller.CardController;
import Controller.iCardController;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
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
    public void mainMenue() throws IOException {
        String selection = "";
        try {
            while (!selection.equals("3")) {
                System.out.println();
                System.out.println("******Hearthstone CardTracker******");
                System.out.println();
                System.out.println("1. Alle Classic Karten anzeigen");
                System.out.println("2. Karte suchen");
                System.out.println("3. Export Deck als XML");
                System.out.println("4. Beenden");


                selection = reader.readLine();


                if ("1".equals(selection)) {
                    showAllCards();

                } else if ("2".equals(selection)) {
                    searchMenue();

                } else if ("3".equals(selection)) {
                    exportToXML();
                } else if ("4".equals(selection)) {
                    stopApp();

                } else {
                    System.out.println("Wählen sie einen Menüpunkt aus");

                }
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     * @throws UnirestException
     */
    public void showAllCards() throws UnirestException {
        try {
            JSONArray all = controller.getAllCards();

            // TODO: 08/04/2019  Alphabetical order not working, has to be fixed... running now without error, but not sorting

            Arrays.sort(new JSONArray[]{all});

            for (int i = 0; i < all.length(); i++) {
                System.out.printf("%-40s%s%n", "Cardname: " + all.getJSONObject(i).getString("name"),
                        "Cardtype: " + all.getJSONObject(i).getString("type"));
            }
        } catch (NullPointerException e){

        }
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
                //Get the Card as string back which was searched and print out to console
//                Minion card = controller.getMinion(cardName);
                String card = controller.getMinion(cardName);
                System.out.println(card);
                System.out.println();
                System.out.println("1. Möchten sie die Karte speichern");
                System.out.println("2. Weiter suchen");
                String selection = reader.readLine();
                if (selection.equals("1")) {
                    controller.insertMinion(cardName);
                }
                if (selection.equals("2")) {
                    searchMenue();
                } else {
                    System.out.println("Wählen sie einen Menüpunkt aus");
                }
            } catch (NullPointerException e) {

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
                String card = controller.getSpell(cardName);
                System.out.println(card);
                System.out.println();
                System.out.println("1. Möchten sie die Karte speichern");
                System.out.println("2. Weiter suchen");
                String selection = reader.readLine();
                if (selection.equals("1")) {
                    controller.insertSpell(cardName);
                }
                if (selection.equals("2")) {
                    searchMenue();
                } else {
                    System.out.println("Wählen sie einen Menüpunkt aus");
                }
            } catch (NullPointerException e) {

            } catch (UnirestException e) {
//                e.printStackTrace();
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

    public void exportToXML() throws SQLException {
        controller.exportDB();
    }
}
