public class Friend extends NPC{


    Friend(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
        super(name, type, health, damage, size, level, posX, posY);
    }

    public void followPlayerForward(Player player, int steps){

      /*  while (player.walkForward(steps)){
            int playerPositionY = player.getPosY();
            this.posY = playerPositionY--;
        }

       */
    }

    public void attackEnemy(){

    };

    public void attackFriend(){

    };

    public void attackPlayer(){

    }

    public void moveForBattle() {

    }

    public void spawn() {

    }

    public void moveNoThreat(){

    }


}
