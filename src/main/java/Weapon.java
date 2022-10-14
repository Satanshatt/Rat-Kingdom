abstract class Weapon {
    String name;
    int damage;
    int speed;

    public Weapon(String name, int damage, int speed){
        this.name = name;
        this.damage = damage;
        this.speed = speed;
    }

    abstract void mainAttack(Player player);

    abstract void secondaryAttack(Player player);

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    public int getSpeed(){
        return speed;
    }
}
