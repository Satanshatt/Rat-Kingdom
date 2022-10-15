public abstract class PlayerDecorator implements Player1 {

    protected Player1 tempPlayer;

    public PlayerDecorator(Player1 newPlayer) {
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
}
