package Models;

public class Minions extends Card {
    public Minions(String name, int cost, int attack, int health, String type, String text, String rarity, String image) {
        super(name, cost, attack, health, type, text, rarity, image);
    }

    public Minions(String name, int cost, String type, String text, String image) {
        super(name, cost, type, text, image);
    }
}
