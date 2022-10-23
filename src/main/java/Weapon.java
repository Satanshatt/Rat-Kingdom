abstract class Weapon extends Equipment {

    public Weapon(Player player, String name) {
        super(player, name);
    }

    protected int levelRandomizer() {
        return (int) (Math.random() * 10) + 1;
    }

    abstract int attackDamage();

    abstract int attackSpeed();

    abstract int getDamage();

    abstract int getSpeed();

    abstract int getWeaponLevel();
}
