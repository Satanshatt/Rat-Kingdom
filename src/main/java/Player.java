import java.awt.*;

public class Player extends Entity {

    private static final int START_POS_X = 1;
    private static final int START_POS_Y = 1;
    private static final int FRET_DAMAGE = 2;
    private static final int XP_KILLING_BONUS = 10;
    private static final int XP_MAX_VALUE = 100;

    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;
    private Weapon activeWeapon;
    private MagicRing magicRing;
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

    public Weapon getActiveWeapon() {
        return this.activeWeapon;
    }

    public MagicRing getActiveMagicRing() {
        return this.magicRing;
    }

    public void increaseHealth(int addedHealth) {
        if (addedHealth < 0)
            throw new IllegalArgumentException("Negative input not possible");
        else
            this.health =+ addedHealth;
    }

    public void setActiveWeapon(Weapon weapon) {
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
        if (this.xp >= XP_MAX_VALUE) {
            increaseLevel();
        }
    }

    public void increaseLevel() {
        this.level = level + 1;
    }

    public void killNPCWithWeapon(NPC npc, Weapon weapon) {
        while (npc.getHealth() > 0)
            useWeaponOnNPC(weapon, npc);
        if (npc.getHealth() <= 0)
            increaseXp(XP_KILLING_BONUS);
    }

    public void killNPCWithoutWeapon(NPC npc) {
        while (npc.getHealth() > 0)
            fret(npc);
        if (npc.getHealth() <= 0)
            increaseXp(XP_KILLING_BONUS);
    }

    public void damagePlayer(int damage) {
        this.health = health - damage;
        if (this.health <= 0)
            die();
    }

    public void move(Room room, int x, int y) {

        if(room.isBlocked(x, y)) {
            throw new IllegalArgumentException("Place is occupied");
        }
        /*else {
            this.setPosX(x);
            this.setPosY(y);
        }

         */
    }

    private boolean isNPCOutOfReach(NPC npc) {
        int npcPosX = npc.posX;
        int npcPosY = npc.posY;
        int playerPosX = this.posX;
        int playerPosY = this.posY;

        if ((playerPosY == npcPosY) &&
                ((playerPosX == (npcPosX + 1)) || (playerPosX == npcPosX - 1))) {
            return false;
        } else if ((playerPosX == npcPosX) &&
                ((playerPosY == (npcPosY + 1)) || (playerPosY == npcPosY - 1))) {
            return false;
        }
        return true;
    }

    public void fret(NPC npc) {
        if (isNPCOutOfReach(npc)) {
            throw new IllegalArgumentException("NPC out of reach");
        }
        npc.takeDamage(FRET_DAMAGE);
    }

    public void kick (NPC npc) {

    }

    public void useWeaponOnNPC(Weapon weapon, NPC npc) {
        //kolla så NPC står inom räckhåll
        int damage = weapon.attackDamage();
        npc.takeDamage(damage);
    }

    public void die() {
        this.isDead = true;
        restart();
    }

    public void pickUpWeapon(Weapon weapon) {
        if (weapon.getWeaponLevel() <= this.level && weapon.getWeaponLevel() >
                this.activeWeapon.getWeaponLevel() || this.activeWeapon == null) {
            this.setActiveWeapon(weapon);
            weapon.setPlayer(this);
        }
    }

    public void pickUpMagicRing(MagicRing magicRing) {
        if (this.magicRing == null){
            this.magicRing = magicRing;
            magicRing.setPlayer(this);
        } else {
            this.magicRing = chooseRing(magicRing);
            magicRing.setPlayer(this);
        }
    }

    public MagicRing chooseRing(MagicRing magicRing){
        return magicRing;
    }

    public void useDoor() {
    }

    public boolean isDead() {
        return isDead;
    }

    public void restart() {
        health = 100;
        mana = 100;
        strength = 10;
        dexterity = 10;
        intelligence = 10;
        xp = 0;
        this.posX = START_POS_X;
        this.posY = START_POS_Y;
        level = 1;
    }

    public Trade getTrade() {
        return this.trade;
    }

    public void chooseTrade(String tradeName) {
        switch (tradeName.toUpperCase()) {
            case "BUILDER" -> this.trade = new Builder(this);
            case "CIRCUS ARTIST" -> this.trade = new CircusArtist(this);
            case "STORYTELLER" -> this.trade = new Storyteller(this);
        }
    }

    public void chooseRace(String raceName) {
        switch (raceName.toUpperCase()) {
            case "BLACK RAT" -> this.race = new BlackRat(this);
            case "BROWN RAT" -> this.race = new BrownRat(this);
            case "WHITE RAT" -> this.race = new WhiteRat(this);
        }
    }

}
