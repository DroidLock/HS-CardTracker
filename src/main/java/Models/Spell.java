package Models;

import javax.persistence.Entity;

@Entity(name = "Spell")
public class Spell extends Card {


    public Spell(String name, int cost, String type, String text, String imgGold) {
        super(name, cost, type, text, imgGold);
    }

    public Spell() {
        super();
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Cardresult: " + '\n' +
                "Name: " + super.getName() + '\n' +
                "Cost: " + super.getCost() + '\n' +
                "Type: " + super.getType() + '\n' +
                "Text: " + super.getText() + '\n' +
                "Image: " + super.getImgGold() + '\n';
    }

}
