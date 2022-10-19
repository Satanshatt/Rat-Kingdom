import java.util.ArrayList;
import java.util.List;

public class BasicPlayer implements Player1 {
    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;

    private ArrayList<Equipment> equipment = new ArrayList<>(); //equipmentBag, backpack ....?

    public BasicPlayer(){
        health = 100;
        mana = 100;
        strength = 10;
        dexterity = 10;
        intelligence = 10;
        xp = 0;
        level = 1;
    }


    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public int getXp() {
        return this.xp;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public List<Equipment> getEquipment() {
        return null;
    }

    @Override
    public void addEquipment(Equipment... equipment) {

    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    private void walk () {

    }

    private void run () {

    }

    private void jump () {

    }

    private void fret () {

    }

    private void boxing () {

    }

    private void whip () {

    }

    private void die () {}

}
