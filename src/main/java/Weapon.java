abstract class Weapon {

    public Weapon() {
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

    abstract void setPlayer(Player player);

    //Only for test
    abstract void setWeaponLevel(int weaponLevel);
}
