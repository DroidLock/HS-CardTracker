package Models;

import javax.persistence.Entity;

@Entity(name = "Minion")
public class Minion extends Card {

    private int attack;
    private int health;
    private String rarity;

    public Minion(String name, int cost, String type, String text, String imgGold, int attack, int health, String rarity) {
        super(name, cost, type, text, imgGold);
        this.attack = attack;
        this.health = health;
        this.rarity = rarity;
    }

    public Minion() {
        super();
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * @return CardString
     */
    @Override
    public String toString() {
        return "Cardresult: " + '\n' +
                "Name: " + super.getName() + '\n' +
                "Cost: " + super.getCost() + '\n' +
                "Attack: " + getAttack() + '\n' +
                "Health: " + getHealth() + '\n' +
                "Type: " + super.getType() + '\n' +
                "Text: " + super.getText() + '\n' +
                "Rarity: " + getRarity() + '\n' +
                "Image: " + super.getImgGold() + '\n';
    }


}

