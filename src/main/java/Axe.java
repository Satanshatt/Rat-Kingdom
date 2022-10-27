public class Axe extends Weapon {
    private static final String NAME = "Axe";
    private final int damage;
    private final int speed;
    private int weaponLevel;
    private Player player;

    public Axe(){
        this.weaponLevel = levelRandomizer();
        this.damage = weaponLevel + 4;
        this.speed = weaponLevel + 2;
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

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setWeaponLevel(int weaponLevel){
        this.weaponLevel = weaponLevel;
    }
}
