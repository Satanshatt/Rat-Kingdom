
public abstract class Enemy extends NPC {

 Enemy(String name, int health, int damage, boolean direction, String type, int posX, int posY) {
  super(name, health, damage, direction, type, posX, posY);
 }

 @Override
 public abstract void attack(Player player);

 public abstract void moveForBattle(Room currentRoom);

}


