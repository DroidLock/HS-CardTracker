package Models;

public class Spell extends Card {

    public Spell(String name, int cost, String type, String text, String image) {
        super(name, cost, type, text, image);
    }

    @Override
    public String toString() {
        return "Cardresult: " + '\n' +
                "Name: " + super.getName() + '\n' +
                "Cost: " + super.getCost() + '\n' +
                "Type: " + super.getType() + '\n' +
                "Text: " + super.getText() + '\n' +
                "Image: " + super.getImage() + '\n';
    }
}
