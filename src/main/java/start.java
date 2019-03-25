import View.ConsoleApp;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class start {
    public static void main(String[] args) throws UnirestException, IOException {

        ConsoleApp app = new ConsoleApp();
        app.mainMenue();
    }
}

