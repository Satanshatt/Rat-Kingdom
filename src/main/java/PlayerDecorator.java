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
        return tempPlayer.getHealth();
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
    public Weapon getActiveWeapon(){
        return tempPlayer.getActiveWeapon();
    }
/*
    @Override
    public List<Equipment> getEquipment() {
        return null;
    }

    @Override
    public void addEquipment(Equipment... equipment) {
    }


 */
    @Override
    public void increaseStrength(int strength) {
        tempPlayer.increaseStrength(strength);
    }

    @Override
    public void setHealth(int health) {
        tempPlayer.setHealth(health);
    }

    @Override
    public void setActiveWeapon(Weapon weapon){
        tempPlayer.setActiveWeapon(weapon);
    }

    @Override
    public void increaseMana(int mana) {
        tempPlayer.increaseMana(mana);
    }

    @Override
    public void increaseDexterity(int dexterity) {
        tempPlayer.increaseDexterity(dexterity);
    }

    @Override
    public void increaseIntelligence(int intelligence) {
        tempPlayer.increaseIntelligence(intelligence);
    }

    @Override
    public void increaseXp(int xP) {
        tempPlayer.increaseXp(xP);
    }

    @Override
    public void increaseLevel() {
        tempPlayer.increaseLevel();
    }

    @Override
    public void walkLeft(int steps) {

    }

    @Override
    public void walkRight(int steps) {}

    @Override
    public void walkForward(int steps) {}

    @Override
    public void useWeaponOnNPC(Weapon weapon, NPC npc) {}

    @Override
    public void die () {}

    @Override
    public boolean isDead() {
        return tempPlayer.isDead();
    }

    @Override
    public void pickUpWeapon(Weapon weapon) {}

    @Override
    public void chooseTrade(String tradeName){}

    @Override
    public void chooseRace(String raceName){}
}
