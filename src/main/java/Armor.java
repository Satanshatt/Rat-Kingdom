abstract class Armor extends Equipment {

    public Armor(Player newPlayer, String name) {
        super(newPlayer, name);
    }

    protected int levelRandomizer() {
        return (int) (Math.random() * 10) + 1;
    }

    abstract int getProtectionValue();

    abstract int getArmorLevel();
}
