abstract class NPC {

    String name = "";
    String type = "";
    int size = 2;
    int damage = 2;
    int health = 2;

    NPC(String name, String type, int health, int damage, int size) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.damage = damage;
        this.size = size;
    }

    public void die(){
        //dö
    }
    abstract public void battle();

    abstract public void moveForBattle();

    abstract public void spawn();
}
