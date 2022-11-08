public class Ant extends Fiend{
    Ant(String name, String type, int health, int damage, int size, int level, int posX, int posY) {
        super(name, type, health, damage, size, level, posX, posY, direction);
    }

    @Override
    public void attackPlayer(Player player) {
        if(this.isPlayerWithinReach(player)){
            player.damagePlayer(this.damage);
        } else {
            return; //Kanske göra annorlunda?
        }
    }

    public void moveForBattle(Room currentRoom){
        boolean justTurnedRight = true;
        int widthOfRoom = currentRoom.getWidth();
        if(justTurnedRight){
        }
        do{



        } while(this.health >= 0);




    }
}
