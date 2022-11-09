public class Owl extends Fiend{
    Owl(String name, String type, int health, int damage, int size, int level, int posX, int posY, boolean direction) {
        super(name, type, health, damage, size, level, posX, posY, direction);
    }

    public void moveForBattle(Room currentRoom) {
        int widthOfRoom = currentRoom.getWidth();
        do{
            if(direction == false){
                int xPosition = this.getPosX();
                int yPosition = this.getPosY();
                Tile currentTile = currentRoom.getTile(xPosition, yPosition);
                this.moveLeft(currentTile);
                if(xPosition == 0){
                    direction = true;
                }
            } else if (direction == true){
                int xPosition = this.getPosX();
                int yPosition = this.getPosY();
                Tile currentTile = currentRoom.getTile(xPosition, yPosition);
                this.moveRight(currentTile);
                if(xPosition == widthOfRoom){
                    direction = false;
                }
            }
        } while(this.health >= 0);
    }

    @Override
    public void attackEnemy() {

    }

    @Override
    public void attackFriend() {

    }

    @Override
    public void attackPlayer(Player player) {
        player.playerTakesDamage(this.getDamage());
        System.out.println("An owl attacked you!");
    }
}
