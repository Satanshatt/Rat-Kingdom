public class BodyArmor extends Armor{
    private static final String NAME = "Body armor";
    private final int protectionValue;
    private final int armorLevel;

    public BodyArmor(Player newPlayer){
        super(newPlayer, NAME);
        this.armorLevel = levelRandomizer();
        this.protectionValue = armorLevel * 5;
    }

    public int getProtectionValue(){
        return protectionValue;
    }

    public int getArmorLevel(){
        return armorLevel;
    }
}
