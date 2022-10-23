import java.util.ArrayList;
import java.util.List;

public class BasicPlayer implements Player {

    private static final int START_POS_X = 0;
    private static final int START_POS_Y = 0;

    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;
    private Equipment activeWeapon;
    private int posX;
    private int posY;

    private ArrayList<Equipment> equipment = new ArrayList<>(); //equipmentBag, backpack ....?

    public BasicPlayer() {
        health = 100;
        mana = 100;
        strength = 10;
        dexterity = 10;
        intelligence = 10;
        xp = 0;
        level = 1;
        this.posX = START_POS_X;
        this.posY = START_POS_Y;
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
    public int getPosX() {
        return this.posX;
    }

    @Override
    public int getPosY() {
        return this.posY;
    }

    @Override
    public List<Equipment> getEquipment() {
        return this.equipment;
    }

    @Override
    public void addEquipment(Equipment... equipment) {
        if(equipment == null)
            throw new IllegalArgumentException("Equipment cannot be null!");
        this.equipment.addAll(List.of(equipment));
    }

    @Override
    public void increaseHealth(int health) {
        this.health = health;
    }

    @Override
    public void increaseMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void increaseStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void increaseDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public void increaseIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void increaseXp(int xp) {
        this.xp = xp;
        if(this.xp >= 100) {
            this.levelUpgrade();
        }
    }

    @Override
    public void levelUpgrade() {
        this.level = level + 1;
    }

    @Override
    public void walkLeft(int steps) {
        if (steps < 0)
            throw new IllegalArgumentException("Negative steps not possible!");
        else if (steps == 0)
            throw new IllegalArgumentException("0 steps will not move the player");
        else
            this.posX = posX - steps;
    }

    @Override
    public void walkRight(int steps) {
        if (steps < 0)
            throw new IllegalArgumentException("Negative steps not possible!");
        else if (steps == 0)
            throw new IllegalArgumentException("0 steps will not move the player");
        else
            this.posX = posX + steps;
    }

    @Override
    public void walkForward(int steps) {
        if (steps < 0)
            throw new IllegalArgumentException("Negative steps not possible!");
        else if (steps == 0)
            throw new IllegalArgumentException("0 steps will not move the player");
        else
            this.posY = posY + steps;

    }

    public void run() {

    }

    public void jump() {

    }

    public void fret() {
        //skada NPC
        //Level, styrka, typ av NPC etc...
    }

    @Override
    public void useWeaponOnNPC (Weapon weapon, NPC npc) {
        int damage = weapon.attackDamage();
        //npc.setDamage(damage);
    }

    public void boxing() {

    }

    public void whip() {

    }

    public void die() {
    }

    public void useDoor() {
    }

}
