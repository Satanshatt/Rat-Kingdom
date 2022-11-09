
public abstract class Enemy extends NPC
 {

  Enemy(String name, int health, int damage, boolean direction, String type, int posX, int posY) {
   super(name, health, damage, direction, type, posX, posY);
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

  public abstract void attackPlayer(Player player);
 }

