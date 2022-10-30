public class Player {

    private static final int START_POS_X = 0;
    private static final int START_POS_Y = 0;

    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;
    private Weapon activeWeapon;
    private int posX;
    private int posY;
    private boolean isDead;
    private Trade trade;
    private Race race;

    public Player() {
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

    public int getHealth() {
        return this.health;
    }

    public int getMana() {
        return this.mana;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getXp() {
        return this.xp;
    }

    public int getLevel() {
        return this.level;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public Weapon getActiveWeapon(){
        return this.activeWeapon;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setActiveWeapon(Weapon weapon){
        this.activeWeapon = weapon;
    }

    public void increaseMana(int mana) {
        this.mana = mana;
    }

    public void increaseStrength(int strength) {
        this.strength = strength;
    }

    public void increaseDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void increaseIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void increaseXp(int xp) {
        this.xp = xp;
        if(this.xp >= 100) {
            this.increaseLevel();
        }
    }

    public void increaseLevel() {

    }

    public void walkLeft(int steps) {
        if (steps < 0)
            throw new IllegalArgumentException("Negative steps not possible!");
        else if (steps == 0)
            throw new IllegalArgumentException("0 steps will not move the player");
        else
            this.posX = posX - steps;
    }

    public void walkRight(int steps) {
        if (steps < 0)
            throw new IllegalArgumentException("Negative steps not possible!");
        else if (steps == 0)
            throw new IllegalArgumentException("0 steps will not move the player");
        else
            this.posX = posX + steps;
    }

    public void walkForward(int steps) {
        if (steps < 0)
            throw new IllegalArgumentException("Negative steps not possible!");
        else if (steps == 0)
            throw new IllegalArgumentException("0 steps will not move the player");
        else
            this.posY = posY + steps;

    }

    public void fret() {
        //skada NPC
        //Level, styrka, typ av NPC etc...
    }

    public void useWeaponOnNPC (Weapon weapon, NPC npc) {
        int damage = weapon.attackDamage();
        //npc.setDamage(damage);
    }

    public void boxing() {

    }

    public void whip() {

    }

    public void die() {
        this.isDead = true;
        restartSameLevel();
    }

    public void pickUpWeapon(Weapon weapon) {

    }

    public void useDoor() {
    }

    public boolean isDead () {
        return isDead;
    }

    public void restartSameLevel () {
        health = 100;
        mana = 100;
        strength = 10;
        dexterity = 10;
        intelligence = 10;
        xp = 0;
        this.posX = START_POS_X;
        this.posY = START_POS_Y;
    }

    public void getWeapon(Weapon weapon){
        if (weapon.getWeaponLevel() <= this.level && this.activeWeapon == null || weapon.getWeaponLevel() > this.activeWeapon.getWeaponLevel()){
            this.setActiveWeapon(weapon);
            weapon.setPlayer(this);
        }
    }

    public void chooseTrade(String tradeName){
        if (tradeName.equals("Builder")){
            this.trade = new Builder(this);
        } else if (tradeName.equals("Circus artist")) {
            this.trade = new CircusArtist(this);
        } else if (tradeName.equals("Storyteller")) {
            this.trade = new Storyteller(this);
        }
    }

    public void chooseRace(String raceName){
        if (raceName.equals("Black rat")){
            this.race = new BlackRat(this);
        } else if (raceName.equals("Brown rat")) {
            this.race = new BrownRat(this);
        } else if (raceName.equals("White rat")) {
            this.race = new WhiteRat(this);
        }
    }
}
