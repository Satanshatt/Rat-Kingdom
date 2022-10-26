abstract class Weapon extends PlayerDecorator {

    public Weapon(Player player) {
        super(player);
    }

    protected int levelRandomizer() {
        return (int) (Math.random() * 10) + 1;
    }

    abstract int attackDamage();

    abstract int attackSpeed();

    abstract int getDamage();

    abstract int getSpeed();

    abstract String getName();

    abstract int getWeaponLevel();

    //Only for test
    abstract void setWeaponLevel(int weaponLevel);
}
