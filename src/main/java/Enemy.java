
public class Enemy extends NPC
 {

  Enemy(String name, String type, int health, int damage, int size, int level) {
   super(name, type, health, damage, size, level);
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

