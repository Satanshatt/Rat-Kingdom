public class Ant extends Fiend{
    Ant(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
        super(name, type, health, damage, size, level, posX, posY, direction);
    }

    boolean justWentRight = false;
    boolean justWentLeft = false;
    boolean justWentUp = false;
    boolean justWentDown = false;

    @Override
    public void attackPlayer(Player player) {
        if(this.isPlayerWithinReach(player)){
            player.playerTakesDamage(this.damage);
            System.out.println("An ant bit you!");
        } else {
            return; //Kanske göra annorlunda?
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

        } while(this.health >= 0);
    }
}
