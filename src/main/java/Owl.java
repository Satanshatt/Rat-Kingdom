public class Owl extends Fiend{
    Owl(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
        super(name, type, health, damage, size, level, posX, posY);
    }

    @Override
    public void moveForBattle() {

        do{
            moveLeft();

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
