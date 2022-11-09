import java.util.Locale;

public class Game {

    Player player;
    Room currentRoom;
    RoomGenerator roomGenerator = new RoomGenerator(10, 10);
    UserInput userInput = new UserInput();

    Game() {

    }

    public void startGame(){
        player = userInput.createPlayer(); //skapa spelare mha metod från input
        currentRoom = roomGenerator.fillRoom("ground").createWallsAndDoors().generate();
        display();

        while(!player.isDead()){
            while(true) {
                display();
                Command userCommand = userInput.getPlayerAction();
                switch (userCommand) {
                    case MOVE:
                        try {
                            player.move(currentRoom, userInput.getDirection());
                        } catch (Exception e) {
                            System.out.println("You cannot go there!");
                        }

                        //npc.move();
                    case ATTACK:
                        //player.attack(NPC npc, userInput.)
                    case TRADE:
                    case PICK_UP_ITEM:
                        //PickUpChoice choice = userInput.getPickUpChoice();
                        //if(choice.equals(PickUpChoice.YES))
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

    public void display(){
       System.out.print(this.currentRoom.generateRoomToShow(player));
    }

}
