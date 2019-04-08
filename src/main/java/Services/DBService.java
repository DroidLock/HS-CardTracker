package Services;

import Models.Card;
import Repository.CardRepository;
import Repository.iCardRepository;

import java.sql.SQLException;

public class DBService implements iDBService {

    iCardRepository repo = new CardRepository();
    /**
     * @param card
     */
    public void saveCard(Card card){
       try{
           repo.saveCard(card);

        System.out.println("Speichern erfolgreich");
       } catch (SQLException e){
           System.out.println("Speichern war nicht erfolgreich");
       }
    }
}
