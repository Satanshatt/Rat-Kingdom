

public class Player {

    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;

    public Player() {
        this.health = 100;
        this.mana = 100;
        this.strength = 10;
        this.dexterity = 10;
        this.intelligence = 10;
        this.xp = 0;
        this.level = 0;
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
}
