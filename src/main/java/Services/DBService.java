package Services;

import Models.Card;
import Repository.CardRepository;
import Repository.iCardRepository;
import com.thoughtworks.xstream.XStream;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
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

    public void exportDeck() throws SQLException{

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;
        try{
            XStream xStream = new XStream();
//            xStream.alias("card", Card.class);
            xStream.alias("deck", Card.class);
            xStream.addImplicitCollection(Card.class, "deck");
            String xml = xStream.toXML(repo.getDeck());
            transformer = transformerFactory.newTransformer();
            FileOutputStream outputStream = new FileOutputStream(new File("C:\\Test"));

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));

            OutputStreamWriter osq = new OutputStreamWriter(outputStream);
            osq.write(xml);
            transformer.transform(new DOMSource(doc), new StreamResult());

            System.out.println(xml);

        } catch (SQLException e){
            System.out.println("Fehler beim Verbindungsaufbau mit der Datenbank");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
