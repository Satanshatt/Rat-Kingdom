import java.util.List;

public abstract class PlayerDecorator implements Player {

    protected Player tempPlayer;

    public PlayerDecorator(Player newPlayer) {
        this.tempPlayer = newPlayer;
    }

    @Override
    public int getStrength() {
        return tempPlayer.getStrength();
    }

    @Override
    public int getHealth() {
        return tempPlayer.getStrength();
    }

    @Override
    public int getMana() {
        return tempPlayer.getMana();
    }

    @Override
    public int getDexterity() {
        return tempPlayer.getDexterity();
    }

    @Override
    public int getIntelligence() {
        return tempPlayer.getIntelligence();
    }

    @Override
    public int getXp() {
        return tempPlayer.getXp();
    }

    @Override
    public int getLevel() {
        return tempPlayer.getLevel();
    }

    @Override
    public int getPosX() {
        return tempPlayer.getPosX();
    }

    @Override
    public int getPosY() {
        return tempPlayer.getPosY();
    }


    @Override
    public List<Equipment> getEquipment() {
        return null;
    }

    @Override
    public void addEquipment(Equipment... equipment) {
    }

    @Override
    public void setStrength(int strength) {
        tempPlayer.setStrength(strength);
    }

    @Override
    public void setHealth(int health) {
        tempPlayer.setHealth(health);
    }

    @Override
    public void setMana(int mana) {
        tempPlayer.setMana(mana);
    }

    @Override
    public void setDexterity(int dexterity) {
        tempPlayer.setDexterity(dexterity);
    }

    @Override
    public void setIntelligence(int intelligence) {
        tempPlayer.setIntelligence(intelligence);
    }

    @Override
    public void setXp(int xP) {
        tempPlayer.setXp(xP);
    }

    @Override
    public void setLevel(int level) {
        tempPlayer.setLevel(level);
    }

    @Override
    public void walkLeft(int steps) {

    }

    @Override
    public void walkRight(int steps) {}

    @Override
    public void walkForward(int steps) {}
}
