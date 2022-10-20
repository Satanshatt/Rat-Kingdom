public class Friend extends NPC{


    Friend(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
        super(name, type, health, damage, size, level, posX, posY);
    }

    public void battle() {

    }

    public void moveForBattle() {

    }

    public void spawn() {

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }
}
