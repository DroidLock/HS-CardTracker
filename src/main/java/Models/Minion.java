package Models;

public class Minion extends Card {
    public Minion(String name, int cost, int attack, int health, String type, String text, String rarity, String image) {
        super(name, cost, attack, health, type, text, rarity, image);
    }

    public Minion(String name, int cost, String type, String text, String image) {
        super(name, cost, type, text, image);
    }

    @Override
    public String toString() {
        return "Cardresult: " + '\n' +
                "Name: " + super.getName() + '\n' +
                "Cost: " + super.getCost() + '\n' +
                "Attack: " + super.getAttack() + '\n' +
                "Health: " + super.getHealth() + '\n' +
                "Type: " + super.getType() + '\n' +
                "Text: " + super.getText() + '\n' +
                "Image: " + super.getImage() + '\n';
    }
}
