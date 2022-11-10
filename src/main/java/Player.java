import java.awt.*;

public class Player extends Entity {

    private static final int START_POS_X = 5; //Ställ fraaför dörren
    private static final int START_POS_Y = 5;
    private static final int FRET_DAMAGE = 2;
    private static final int XP_KILLING_BONUS = 10;
    private static final int XP_MAX_VALUE = 100;
    private static final int HEALTH_MAX_VALUE = 100;
    private static final int MANA_BONUS = 15;

    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;
    private boolean isDead;
    private Weapon activeWeapon;
    private MagicRing magicRing;
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

    //Testad
    public int getXp() {
        return this.xp;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isDead () {
        return isDead;
    }

    public Weapon getActiveWeapon() {
        return this.activeWeapon;
    }

    public MagicRing getActiveMagicRing() {
        return this.magicRing;
    }

    public Race getRace () {
        return this.race;
    }

    public Trade getTrade() {
        return this.trade;
    }

    public void increaseHealth(int addedHealth) {
        if (addedHealth <= 0)
            throw new IllegalArgumentException("Input less or equal to 0 not possible");
        else
            this.health =+ addedHealth;
        if(this.health > HEALTH_MAX_VALUE)
            this.health = HEALTH_MAX_VALUE;
    }

    public void setActiveWeapon(Weapon weapon) {
        if (weapon == null) {
            throw new IllegalArgumentException("Weapon cannot be null");
        }
        this.activeWeapon = weapon;
    }

    public void increaseStrength(int strength) {
        if (strength <= 0)
            throw new IllegalArgumentException("Input less or equal to 0 not possible");
        else
            this.strength = strength;
    }

    public void increaseDexterity(int dexterity) {
        if (dexterity <= 0)
            throw new IllegalArgumentException("Input less or equal to 0 not possible");
        else
            this.dexterity = dexterity;
    }

    public void increaseIntelligence(int intelligence) {
        if (intelligence <= 0)
            throw new IllegalArgumentException("Input less or equal to 0 not possible");
        else
            this.intelligence = intelligence;
    }

    public void increaseXp(int addXp) {
        if (addXp <= 0)
            throw new IllegalArgumentException("Input less or equal to 0 not possible");
        else
            this.xp =+ addXp;
        if (this.xp >= XP_MAX_VALUE) {
            increaseLevel(); //Sätt tillbaka xp på 0
        }
    }

    public void increaseMana(int mana) {
        if (mana <= 0)
            throw new IllegalArgumentException("Input less or equal to 0 not possible");
        else
            this.mana = mana;
    }

    public void increaseLevel() {
        this.level = level + 1;
        this.mana = mana + MANA_BONUS;

    }

    public void playerTakesDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Negative damage not possible");
        }
        this.health = health - damage;
        if (this.health <= 0)
            this.die();
    }

    public void attack (NPC npc, AttackChoice attackChoice) {
        switch (attackChoice) {
            case WITH_WEAPON -> {
                useWeaponOnNPC(npc);
            }
            case FRET -> {
                fret(npc);
            }
        }
        if(npc.getHealth() < 0) {
            this.increaseXp(XP_KILLING_BONUS);
            //npc.die()
        }
    }

    public void move(Room room, Direction direction) {
        int newXPos = this.getPosX();
        int newYPos = this.getPosY();
        switch(direction) {
            case LEFT -> {
                newXPos -= 1;
            }
            case RIGHT -> {
                newXPos += 1;
            }
            case UPWARDS -> {
                newYPos -= 1;
            }
            case DOWNWARDS -> {
                newYPos += 1;
            }
        }

        if(room.isBlocked(newXPos, newYPos)) {
            throw new IllegalArgumentException("Place is occupied");
        }
        else {
            this.setPosX(newXPos);
            this.setPosY(newYPos);

        }
    }

    public boolean isNPCWithinReach(NPC npc) { //within reach
        int npcPosX = npc.posX;
        int npcPosY = npc.posY;
        int playerPosX = this.posX;
        int playerPosY = this.posY;

        if ((playerPosY == npcPosY) &&
                ((playerPosX == (npcPosX + 1)) || (playerPosX == npcPosX - 1))) {
            return true;
        } else if ((playerPosX == npcPosX) &&
                ((playerPosY == (npcPosY + 1)) || (playerPosY == npcPosY - 1))) {
            return true;
        }
        return false;
    }

    public void fret(NPC npc) {
        if (!isNPCWithinReach(npc)) {
            throw new IllegalArgumentException("Enemy out of reach");
        }
        npc.takeDamage(FRET_DAMAGE);
    }

    public void useWeaponOnNPC(NPC npc) {
        if (!isNPCWithinReach(npc)) {
            throw new IllegalArgumentException("NPC out of reach");
        }
        int damage = activeWeapon.attackDamage();
        npc.takeDamage(damage);
    }

    public void die() {
        isDead = true;
        restart();
    }

    public void pickUpWeapon(Weapon weapon) {
            this.setActiveWeapon(weapon);
            weapon.setPlayer(this);
    }

    public void pickUpMagicRing(MagicRing magicRing) {
        this.magicRing = magicRing;
        magicRing.setPlayer(this);
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
        isDead = false;
    }

    public void chooseTrade(TradeChoice tradeChoice) {
        switch (tradeChoice) {
            case BUILDER -> this.trade = new Builder(this);
            case STORYTELLER -> this.trade = new Storyteller(this);
            case CIRCUS_ARTIST -> this.trade = new CircusArtist(this);
        }
    }

    public void chooseRace(RaceChoice raceChoice) {
        switch (raceChoice) {
            case BLACK_RAT -> this.race = new BlackRat(this);
            case BROWN_RAT -> this.race = new BrownRat(this);
            case WHITE_RAT -> this.race = new WhiteRat(this);
        }
    }
}
