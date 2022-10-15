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

    private ArrayList <String> equipment = new ArrayList<>();

    public Player(Trade trade, Race race) {
        this.health = 100;
        this.mana = 100;
        this.strength = 10;
        this.dexterity = 10;
        this.intelligence = 10;
        this.xp = 0;
        this.level = 0;
        this.race = race;
        if(trade != null)
            this.trade = trade;
        else
            throw new IllegalStateException();
        //this.trade = chooseTrade(trade);
        //this.trade.raiseAttribute(this);
    }

  /*  public Trade chooseTrade(String chosenTrade){
        if (chosenTrade.equalsIgnoreCase("Builder")){
            return new BuilderTrade(this);
        } else if (chosenTrade.equalsIgnoreCase("Circus artist")){
            return new CircusArtistTrade();
        } else if (chosenTrade.equalsIgnoreCase("Storyteller")){
            return new StorytellerTrade();
        } else return null;
    }

    Kommenterar bort tillfälligt.
    Varför gå igenom en metod, när vi kan skicka in yrket direkt?
    Är det möjligt att ha ett yrke som är null?
   */

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

    public void walk () {

    }

    public void run () {

    }

    public void jump () {

    }

    public void fret () {

    }

    public void boxing () {

    }

    public void whip () {

    }

    public void die () {}

}
