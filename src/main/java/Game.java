import java.util.Locale;

public class Game {

    Player player;
    Room currentRoom;
    RoomGenerator roomGenerator = new RoomGenerator(10, 10);
    UserInput userInput = new UserInput();

    Map map = new Map();

    Game() {

    }

    public void startGame(){
        player = userInput.createPlayer(); //skapa spelare mha metod från input
        for(int i = 0; i<map.getRooms().size();i++){

            currentRoom = map.getRooms().get(i);

            while(!player.isDead()){
                while(true) {
                    display();
                    Command userCommand = userInput.getPlayerAction();
                    switch (userCommand) {
                        case MOVE:
                            player.move(currentRoom, userInput.getDirection());
                            //npc.move();
                        case ATTACK:
                            //player.attack(NPC npc, userInput.)
                        case TRADE:
                        case PICK_UP_ITEM:
                            if(userInput.getPickUpChoice().equals(PickUpChoice.YES))
                                //player.pickUpWeapon();
                                break;
                        case ENTER_NEXT_ROOM:
                        default:
                            System.out.println("Please only type one letter! M, A, T or P.");
                            break;
                    }
                }
            }
        }

    }

    public void display(){
        System.out.print(this.currentRoom.generateRoomToShow(player));
    }

}
