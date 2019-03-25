package View;

import Models.Card;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public interface iConsoleApp {
    //String or void in Method=????

    public String mainMenue() throws IOException;

    public void searchMenue() throws UnirestException, IOException;

    public String showAllCards() throws UnirestException;

    public void searchMinion() throws IOException;

    public void searchSpell() throws IOException;

    public void stopApp();

    public void saveCard();


}

