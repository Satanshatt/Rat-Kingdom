public class Owl extends Enemy{
    Owl(int posX, int posY) {
        super("Owl", 35, 15, false, "Enemy", posX, posY);
    }


    @Override
    public void attack(Player player) {
        player.playerTakesDamage(this.getDamage());
        System.out.println("An owl attacked you!");
    }

    @Override
    public void moveForBattle(Room currentRoom) {
        int xPosition = this.getPosX();
        int yPosition = this.getPosY();

        if(this.getDirection()) {
            xPosition += 1;
        }
        else {
            xPosition -= 1;
        }

        Tile currentTile = currentRoom.getTile(xPosition, yPosition);

        if(currentTile.isBlocked()){ // ska denna if-sats ligga efter att vi flyttat redan?
            this.setDirection(!this.getDirection());
        }

        if(this.getDirection()){
            this.moveRight(currentTile);
        } else {
            this.moveLeft(currentTile); //kolla vad som händer om vägen är blockad
        }
    }

}
