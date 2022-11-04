abstract class MagicRing {
    public MagicRing() {
    }

    protected int levelRandomizer() {
        return (int) (Math.random() * 10) + 1;
    }

    abstract int attackDamage();

    abstract int attackSpeed();

    abstract String getName();

    abstract void setPlayer(Player player);

}
