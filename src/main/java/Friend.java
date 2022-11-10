public abstract class Friend extends NPC{


    Friend(String name, int health, int damage, boolean direction, String type, int posX, int posY) {
        super(name, health, damage, direction, type, posX, posY);
    }

    public void followPlayer (Player player, int steps){

    }

    public abstract void attack(Player player);

    public abstract void moveForBattle(Room currentRoom);


    public void moveNoThreat(){

    }


}
