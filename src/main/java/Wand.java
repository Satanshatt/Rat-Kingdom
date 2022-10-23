public class Wand extends Weapon {
    private static final String NAME = "Wand";
    private final int weaponLevel;
    private final int damage;
    private final int speed;

    public Wand(Player newPlayer){
        super(newPlayer, NAME);
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

    public int getWeaponLevel(){
        return weaponLevel;
    }
}
