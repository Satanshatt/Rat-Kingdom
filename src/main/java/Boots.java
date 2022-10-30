public class Boots extends Armor {
    private static final String NAME = "BOOTS";
    private final int protectionValue;
    private final int armorLevel;

    public Boots(OldPlayer player){
        super(player, NAME);
        this.armorLevel = levelRandomizer();
        this.protectionValue = armorLevel * 3;
    }

    public int getProtectionValue(){
        return protectionValue;
    }

    public int getArmorLevel(){
        return armorLevel;
    }
}
