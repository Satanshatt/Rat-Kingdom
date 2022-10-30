import java.awt.*;

public class Player extends Entity {

    private static final int START_POS_X = 0;
    private static final int START_POS_Y = 0;
    private static final int FRET_DAMAGE = 2;

    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;
    private Weapon activeWeapon;
    private boolean isDead;
    private Trade trade;
    private Race race;



    public Player() {
        super("Player", START_POS_X, START_POS_Y);
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

    public Weapon getActiveWeapon(){
        return this.activeWeapon;
    }

    public void increaseHealth(int addedHealth) {
        if((this.health =+ addedHealth) >= 100)  {
            this.health = 100;
        } else
            this.health =+ addedHealth;
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

    public void increaseXp(int addXp) {
        this.xp =+ addXp;
        if(this.xp >= 100) {
            increaseLevel();
        }
    }

    public void increaseLevel() {
        this.level = level + 1;
    }

    public void killNPCWithWeapon (NPC npc, Weapon weapon) {
        while (npc.getHealth() > 0)
         useWeaponOnNPC(weapon, npc);
        if (npc.getHealth() <= 0)
            increaseXp(10);
    }

    public void killNPCWithoutWeapon (NPC npc) {
        while (npc.getHealth() > 0)
            fret(npc);
        if (npc.getHealth() <= 0)
            increaseXp(10);
    }

    public void damagePlayer (int damage) {
        this.health = health - damage;
        if (this.health <= 0)
            die();
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

    private boolean isNPCOutOfReach (NPC npc) {
        int npcPosX = npc.posX;
        int npcPosY = npc.posY;
        int playerPosX = this.posX;
        int playerPosY = this.posY;

        if((playerPosY == npcPosY) &&
                ((playerPosX == (npcPosX + 1)) ||  (playerPosX == npcPosX - 1))){
            return false;
        } else if ((playerPosX == npcPosX) &&
                ((playerPosY == (npcPosY + 1)) ||  (playerPosY == npcPosY - 1))) {
            return false;
        }
        return true;
    }

    public void fret(NPC npc) {
        if(isNPCOutOfReach(npc)) {
            throw new IllegalArgumentException("NPC out of reach");
        }
        npc.takeDamage(FRET_DAMAGE);

    }

    public void useWeaponOnNPC (Weapon weapon, NPC npc) {
        //kolla så NPC står inom räckhåll
        int damage = weapon.attackDamage();
        npc.takeDamage(damage);
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
        /*
        if (weapon.getWeaponLevel() <= this.level && weapon.getWeaponLevel() > this.activeWeapon.getWeaponLevel() || this.activeWeapon == null ){
            this.setActiveWeapon(weapon);
            weapon.setPlayer(this);
        }
         */
    }

    public Trade getTrade () {
        return this.trade;
    }

    public void chooseTrade(String tradeName) {
        if (tradeName.equals("Builder")) {
            this.trade = new Builder(this);
        } else if (tradeName.equals("Circus artist")) {
            this.trade = new CircusArtist(this);
        } else if (tradeName.equals("Storyteller")) {
            this.trade = new Storyteller(this);
        }

        }

        public void chooseRace (String raceName){

            if (raceName.equals("Black rat")) {
                this.race = new BlackRat(this);
            } else if (raceName.equals("Brown rat")) {
                this.race = new BrownRat(this);
            } else if (raceName.equals("White rat")) {
                this.race = new WhiteRat(this);
            }


        }

}
