abstract class Armor extends Equipment {

    public Armor(Player player, String name) {
        super(player, name);
    }

    abstract int getProtectionValue();

    abstract int getArmorLevel();
}
