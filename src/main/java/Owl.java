public class Owl extends Fiend{
    Owl(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
        super(name, type, health, damage, size, level, posX, posY);
    }

    public void moveForBattle(Room currentRoom) {
        int widthOfRoom = currentRoom.getWidth();

        do{


        } while(this.health >= 0);
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
}
