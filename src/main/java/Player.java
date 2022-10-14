import java.util.ArrayList;
import java.util.List;

public class Player {
//ändring 2
    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;
    private Race race;
    private Trade trade;

    private String [] abilities = {"walk", "run", "jump", "fret", "boxing", "whip"};
    private ArrayList <String> equipment = new ArrayList<>();

    public Player(String trade) {
        this.health = 100;
        this.mana = 100;
        this.strength = 10;
        this.dexterity = 10;
        this.intelligence = 10;
        this.xp = 0;
        this.level = 0;
        this.trade = chooseTrade(trade);
        this.trade.raiseAttribute(this);
    }

    public Trade chooseTrade(String chosenTrade){
        if (chosenTrade.equalsIgnoreCase("Builder")){
            return new BuilderTrade();
        } else return null;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public Race getRace() {
        return race;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void addEquipment (String equipment) {

    }

    public List<String> getEquipment () {
        return equipment;
    }

}
