public class Rattlesnake extends Enemy{
    Rattlesnake(int posX, int posY) {
        super("Rattlesnake", 75, 10, false, "Enemy", posX, posY);
    }

    @Override
    public void attack(Player player) {
        if(this.isPlayerWithinReach(player)){
            player.playerTakesDamage(this.getDamage());
            System.out.println("A rattlesnake bit you!");
        } else {
            return; //Kanske göra annorlunda?
        }
    }

    public void moveForBattle(Room currentRoom){

        int heightOfRoom = currentRoom.getHeight();
        boolean justWentRight = false;
        boolean justWentLeft = false;
        boolean justWentUp = false;
        boolean justWentDown = false;

        do{
            if(this.getDirection()) {
                int xPosition = this.getPosX();
                int yPosition = this.getPosY();
                Tile currentTile = currentRoom.getTile(xPosition, yPosition);

                if(justWentLeft){
                    this.moveUpwards(currentTile);
                    justWentUp = true;
                    justWentLeft = false;
                }

                if(justWentUp){
                    this.moveLeft(currentTile);
                    justWentLeft = true;
                    justWentUp = false;
                }

                if(yPosition == 0){
                    this.setDirection(true);
                }

            } else if (!this.getDirection()) {
                int xPosition = this.getPosX();
                int yPosition = this.getPosY();
                Tile currentTile = currentRoom.getTile(xPosition, yPosition);

                if(justWentDown){
                    this.moveRight(currentTile);
                    justWentRight = false;
                    justWentDown = true;
                }

                if(justWentRight){
                    this.moveLeft(currentTile);
                    justWentRight = true;
                    justWentDown = false;
                }

                this.moveRight(currentTile);
                if(yPosition == heightOfRoom){
                    this.setDirection(false);
                }
            }

        } while(this.getHealth() >= 0);

    }
}
