abstract class Weapon extends Equipment {

    public Weapon(Player player, String name) {
        super(player, name);
    }

    abstract int attackDamage();

    abstract int attackSpeed();

    abstract int getDamage();

    abstract int getSpeed();

    abstract int getWeaponLevel();
}
