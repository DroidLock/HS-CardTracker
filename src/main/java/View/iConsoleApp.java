package View;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.sql.SQLException;

public interface iConsoleApp {
    //String or void in Method=????

    public void mainMenue() throws IOException;

    public void searchMenue() throws UnirestException, IOException;

    public void showAllCards() throws UnirestException;

    public void searchMinion() throws IOException;

    public void searchSpell() throws IOException;

    public void exportToXML() throws SQLException;

    public void stopApp();
}

