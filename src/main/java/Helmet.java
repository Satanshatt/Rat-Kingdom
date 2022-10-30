public class Helmet extends Armor {
    private static final String NAME = "HELMET";
    private final int protectionValue;
    private final int armorLevel;

    public Helmet(OldPlayer player){
        super(player, NAME);
        this.armorLevel = levelRandomizer();
        this.protectionValue = armorLevel * 2;
    }

    public int getProtectionValue(){
        return protectionValue;
    }

    public int getArmorLevel(){
        return armorLevel;
    }
}
