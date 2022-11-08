public class Sword extends Weapon{
    private static final String NAME = "Sword";
    private final int damage;
    private final int speed;
    private int weaponLevel;
    private Player player;

    public Sword(){
        this.weaponLevel = levelRandomizer();
        this.damage = weaponLevel + 2;
        this.speed = weaponLevel + 4;
    }

    public int attackDamage(){
        return player.getStrength() + damage;
    }

    public int attackSpeed(){
        return player.getDexterity() + speed;
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

    public void setPlayer(Player player){
        this.player = player;
    }

    public String toString() {
        return NAME;
    }
}
