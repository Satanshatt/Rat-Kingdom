public abstract class DecoratorPlayer implements Player1 {

    protected Player1 tempPlayer;

    public DecoratorPlayer (Player1 newPlayer) {
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
    public void setStrength(int strength) {
        tempPlayer.setStrength(strength);
    }

    abstract void addStrength(int strength);
}
