public class Wand extends Weapon {
    private static final String NAME = "Wand";
    private final int damage;
    private final int speed;
    private int weaponLevel;

    public Wand(Player player){
        super(player);
        this.weaponLevel = levelRandomizer();
        this.damage = weaponLevel + 3;
        this.speed = weaponLevel + 3;
    }

    public int attackDamage(){
        return tempPlayer.getIntelligence() + damage;
    }

    public int attackSpeed(){
        return tempPlayer.getDexterity() + speed;
    }

    public int getDamage(){
        return damage;
    }

    public int getSpeed(){
        return speed;
    }

    public String getName(){
        return NAME;
    }

    public int getWeaponLevel(){
        return weaponLevel;
    }

    public void setWeaponLevel(int weaponLevel){
        this.weaponLevel = weaponLevel;
    }
}
