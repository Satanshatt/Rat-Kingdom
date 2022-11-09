public abstract class Rattlesnake extends Fiend{
    Rattlesnake(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
        super(name, type, health, damage, size, level, posX, posY, direction);
    }

    @Override
    public void attackPlayer(Player player) {
        if(this.isPlayerWithinReach(player)){
            player.playerTakesDamage(this.damage);
            System.out.println("Rattlesnake bit you!");
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
            if(direction == false) {
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
                    direction = true;
                }

            } else if (direction == true) {
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
                    direction = false;
                }
            }

        } while(this.health >= 0);

    }
}
