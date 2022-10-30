abstract class Armor extends Equipment {

    public Armor(OldPlayer player, String name) {
        super(player, name);
    }

    abstract int getProtectionValue();

    abstract int getArmorLevel();
}
