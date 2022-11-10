public class Traitor extends Friend{

    Traitor(String name, int health, int damage, boolean direction, String type, int posX, int posY) {
        super(name, health, damage, direction, type, posX, posY);
    }

    @Override
    public void attack(Player player) {

    }

    @Override
    public void moveForBattle(Room currentRoom) {

    }
}
