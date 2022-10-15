public class BasicPlayer implements Player1 {

    private int strength;
    private int health;
    private int mana;
    private int dexterity;
    private int intelligence;
    private int xp;
    private int level;

    @Override
    public int getStrength() {
        return this.strength;
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
    public void setStrength(int strength) {
        this.strength = strength;
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

}
