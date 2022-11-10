public class Ant extends Enemy{
    Ant(int posX, int posY) {
        super("Ant", 50, 5, false, "Enemy", posX, posY);
    }

    boolean justWentRight = false;
    boolean justWentLeft = false;
    boolean justWentUp = false;
    boolean justWentDown = false;

    @Override
    public void attack(Player player) {
        if(this.isPlayerWithinReach(player)){
            player.playerTakesDamage(this.getDamage());
            System.out.println("An ant bit you!");
        } else {
            System.out.println("The ant missed when attacking!");
        }
    }

    public void moveForBattle(Room currentRoom){

        do{

            int xPosition = this.getPosX();
            int yPosition = this.getPosY();
            Tile currentTile = currentRoom.getTile(xPosition, yPosition);

            if(justWentRight){
                this.moveDownwards(currentTile);
                justWentDown = true;
                justWentRight = false;
            }

            if(justWentDown){
                this.moveLeft(currentTile);
                justWentLeft = true;
                justWentDown = false;
            }

            if(justWentLeft) {
                this.moveUpwards(currentTile);
                justWentUp = true;
                justWentLeft = false;
            }

            if(justWentUp){
                this.moveRight(currentTile);
                justWentRight = true;
                justWentUp = false;

            } else {
                this.moveRight(currentTile);
                justWentRight = true;
            }

        } while(this.getHealth() >= 0);
    }
}
