public class BasicPlayer implements Player1 {

    private int strength;
    private int health;

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

}
