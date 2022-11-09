public class Owl extends Enemy{
    Owl(String name, int health, int damage, boolean direction, String type, int posX, int posY) {
        super(name, health, damage, direction, type, posX, posY);
    }

    public void moveForBattle(Room currentRoom) {
        int widthOfRoom = currentRoom.getWidth();
        do{
            if(this.getDirection()){
                int xPosition = this.getPosX();
                int yPosition = this.getPosY();
                Tile currentTile = currentRoom.getTile(xPosition, yPosition);
                this.moveLeft(currentTile); //kolla vad som händer om vägen är blockad
                if(xPosition == 0){ // ska denna if-sats ligga efter att vi flyttat redan?
                    this.setDirection(true);
                }
            } else if (!this.getDirection()){
                int xPosition = this.getPosX();
                int yPosition = this.getPosY();
                Tile currentTile = currentRoom.getTile(xPosition, yPosition);
                this.moveRight(currentTile);
                if(xPosition == widthOfRoom){
                    this.setDirection(true);
                }
            }
        } while(this.getHealth() >= 0);
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
