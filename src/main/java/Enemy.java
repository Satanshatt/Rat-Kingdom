
public class Enemy extends NPC
 {

  Enemy(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
   super(name, type, health, damage, size, level, posX, posY);
  }

  @Override
  public void attackEnemy() {

  }

  @Override
  public void attackFriend() {

  }

  @Override
  public void attackPlayer() {

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

