package Models;

public class Card {
    private String name;
    private int cost;
    private int attack;
    private int health;
    private String type;
    private String text;
    private String rarity;
    private String imgGold;

    public Card(String name, int cost, int attack, int health, String type, String text, String rarity, String imgGold) {
        this.name = name;
        this.cost = cost;
        this.attack = attack;
        this.health = health;
        this.type = type;
        this.text = text;
        this.rarity = rarity;
        this.imgGold = imgGold;
    }

    public Card(String name, int cost, String type, String text, String imgGold) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.text = text;
        this.imgGold = imgGold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getImgGold() {
        return imgGold;
    }

    public void setImgGold(String imgGold) {
        this.imgGold = imgGold;
    }


}
