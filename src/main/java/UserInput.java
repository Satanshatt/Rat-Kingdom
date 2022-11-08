import java.util.*;

enum Direction{
    UPWARDS,
    DOWNWARDS,
    LEFT,
    RIGHT
}

enum Command{
    MOVE,
    ATTACK,
    TRADE,
    PICK_UP_ITEM,
    ENTER_NEXT_ROOM
}

enum RaceChoice{
    BLACK_RAT,
    BROWN_RAT,
    WHITE_RAT
}

enum TradeChoice{
    BUILDER,
    CIRCUS_ARTIST,
    STORYTELLER
}

public class UserInput {

    public final String  WALK_UPWARDS = "U";
    public final String WALK_DOWNWARDS = "D";
    public final String WALK_LEFT = "L";
    public final String WALK_RIGHT = "R";
    public final String MOVE = "M";
    public final String ATTACK = "A";
    public final String TRADE = "T";
    public final String PICK_UP_ITEM = "P";
    public final String ENTER_NEXT_ROOM = "E";
    public final String BUILDER = "B";
    public final String CIRCUS_ARTIST = "C";
    public final String STORYTELLER = "S";
    public final String BLACK_RAT = "BLACK";
    public final String WHITE_RAT = "WHITE";
    public final String BROWN_RAT = "BROWN";


    Scanner sc = new Scanner(System.in);

    public Player createPlayer(){

        return new Player();
    }

    //public Race getPlayerRace(){}

    public Command getPlayerAction(){

       while(true) {
           System.out.println("Choose action: (M)ove, (A)ttack, (T)rade or (P)ick up item.");
           String userInput = sc.nextLine().trim();

           switch (userInput.toUpperCase(Locale.ROOT)) {
               case MOVE:
                   return Command.MOVE;
               case ATTACK:
                   return Command.ATTACK;
               case TRADE:
                   return Command.TRADE;
               case PICK_UP_ITEM:
                   return Command.PICK_UP_ITEM;
               case ENTER_NEXT_ROOM:
                   return Command.ENTER_NEXT_ROOM;
               default:
                   System.out.println("Please only type one letter! M, A, T or P.");
                   break;
           }
       }

   }

   public Direction getDirection() {
       System.out.println("Where do you want to move: (U)pwards, (D)ownwards, (L)eft, (R)ight");
       String userInput = sc.nextLine().trim();
       while(true) {
           switch(userInput.toUpperCase(Locale.ROOT)) {
               case WALK_UPWARDS:
                   return Direction.UPWARDS;
               case WALK_DOWNWARDS:
                   return Direction.DOWNWARDS;
               case WALK_LEFT:
                   return Direction.LEFT;
               case WALK_RIGHT:
                   return Direction.RIGHT;
               default:
                   System.out.println("Please only type one letter! U, D, L or R.");
                   break;

           }
       }

   }
}



